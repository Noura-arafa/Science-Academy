package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author norhan
 */
abstract public class UserModel {

	protected String Name;
	protected String Gender;
	protected int Age;
	protected String email;
	protected String userName;
	protected String Password;

	abstract void AddRecord(UserModel inf, String type);

	public boolean TakePermission(String gameOwner, String GameName) {
		return true;

	}

	abstract boolean Verify(String UserName, String Password);
}