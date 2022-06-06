package com.renzvi.mss.repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.reflect.TypeToken;
import com.renzvi.mss.factory.ConnectionFactory;
import com.renzvi.mss.model.entities.Entity;

public abstract class AbstractCRUD<T extends Entity> {

	private String tableName;
	private TypeToken<T> type;

	protected AbstractCRUD(String tableName) {
		this.tableName = tableName;
		this.type = new TypeToken<T>(getClass()) {
			private static final long serialVersionUID = 1L;
		};
	}

	public void save(T entity) {
		if (StringUtils.isBlank(entity.getUuid())) {
			insert(entity);
		} else {
			update(entity);
		}
	}

	private void insert(T entity) {

		entity.setUuid(UUID.randomUUID().toString());

		List<Object> values = getValues(entity);

		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn
						.prepareStatement(String.format("insert into %s(%s,%s) values('%s',%s)", tableName, Entity.UUID,
								String.join(",", getColumns(entity)), entity.getUuid(), getInterrogations(values)))) {

			setValues(ps, values);
			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void update(T entity) {

		List<String> collumns = getColumns(entity);
		List<Object> values = getValues(entity);

		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn.prepareStatement(String.format("update %s set %s where %s = '%s'",
						tableName, getSetters(collumns), Entity.UUID, entity.getUuid()))) {

			setValues(ps, values);
			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(T entity) {

		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn.prepareStatement(
						String.format("delete from %s where %s = '%s'", tableName, Entity.UUID, entity.getUuid()))) {

			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public T get(T entity) {

		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn.prepareStatement(
						String.format("select * from %s where %s = '%s'", tableName, Entity.UUID, entity.getUuid()))) {

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					setValues(rs, entity);
				}

			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		List<T> results = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn.prepareStatement(String.format("select * from %s", tableName))) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					
					Class<?> clazz = Class.forName(this.type.getRawType().getName());
					Constructor<?> ctor = clazz.getConstructor();
					T entity = (T) ctor.newInstance();
					
					entity.setUuid(rs.getString(Entity.UUID));
					setValues(rs, entity);
					results.add((T) entity);
				}

			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException
					| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				throw new RuntimeException(e1);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return results;
	}
	
	private void setValues(ResultSet rs, T entity) {

		List<String> collumns = getColumns(entity);
		List<Method> methods = getSetters(entity);

		for (String collumn : collumns) {

			try {
				methods.stream().filter(method -> method.getName().toLowerCase().equals("set" + collumn))
						.collect(Collectors.toList()).get(0).invoke(entity, rs.getObject(collumn));
			} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private List<Method> getSetters(T entity) {
		return getMethodsByPrefix(entity, "set");
	}

	private List<Method> getGetters(T entity) {
		return getMethodsByPrefix(entity, "get");
	}

	private List<Method> getMethodsByPrefix(T entity, String prefix) {

		List<Method> results = new ArrayList<>();

		Field[] fields = entity.getClass().getDeclaredFields();

		for (Field field : fields) {

			String name = field.getName();

			Method[] methods = entity.getClass().getMethods();

			for (Method method : methods) {

				if (method.getName().toLowerCase().equals(prefix + name.toLowerCase())) {

					results.add(method);
				}
			}
		}

		return results;
	}

	private void setValues(PreparedStatement ps, List<Object> values) throws SQLException {
		for (int i = 0; i < values.size(); i++) {
			ps.setObject(i + 1, values.get(i));
		}
	}

	private List<String> getColumns(T entity) {

		Field[] fields = entity.getClass().getDeclaredFields();

		return Arrays.asList(fields).stream().map(field -> field.getName()).collect(Collectors.toList());
	}

	private List<Object> getValues(T entity) {

		List<Method> methods = getGetters(entity);

		return methods.stream().map(method -> {
			try {
				return method.invoke(entity);
			} catch (SecurityException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}

	private String getInterrogations(List<Object> values) {
		return String.join(",", values.stream().map(item -> "?").collect(Collectors.toList()));
	}

	private String getSetters(List<String> collumns) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < collumns.size(); i++) {
			result.add(String.format("%s = ?", collumns.get(i)));
		}
		return String.join(",", result);
	}

}
