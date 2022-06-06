package com.renzvi.mss.repository;

import com.renzvi.mss.model.entities.Account;

public class AccountRepository extends AbstractCRUD<Account> {

	protected AccountRepository() {
		super("account");
	}

}
