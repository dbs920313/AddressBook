package Address;

import java.io.*;
import java.util.*;
import java.lang.Thread.State;
import java.sql.*;

@SuppressWarnings("unused") // ������� �ʴ� �ڵ���� ��� ����

public class AddressBook {
	// DataOutputStream fOut = null; // ���� ���� ������ write�� ���̴� ���� fOut
	// ObjectInputStream fIn = null; // ���� ���� ������ read�� ���̴� ���� fIn
	// private Person[] p;
	// private ArrayList<Person> people;
	// private int count; // size()�� ������ ����//���÷� �ٲ�� �� ��...��
	// db�� �����ϱ� ���� �ʿ��� ����
	private Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String url;

	// ������
	AddressBook(String url, Connection con) throws Exception {
		this.url = url;
		this.con = con;
		getConnection();
	}

	/*
	 * public AddressBook(int num) throws Exception {// UI���� ������ ����� �� �����ͼ� ��ü ����
	 * people = new ArrayList<Person>(num); // p = new Person[num]; }
	 * 
	 * public AddressBook(int num, ObjectInputStream fn) throws Exception {// UI����
	 * ������ ����� �� �����ͼ� ��ü ���� //fIn = fn; // p = new Person[num];
	 * 
	 * people = new ArrayList<Person>(num); try { readFile(fn); } catch (IOException
	 * e) { throw new IOException("IOException"); } catch (NullPointerException e)
	 * {//??? throw new IOException("NullPointerException"); } }
	 */
	void getConnection() throws ClassNotFoundException, SQLException {
		// ����̹� �ε�
		Class.forName("org.mariadb.jdbc.Driver");
		// statement ���
		stmt = con.createStatement();
	}

	/*
	 * public int getCount() { // ��ϵ� ��� �� ������ // return count; return
	 * people.size(); }
	 */
	// �������� Ȯ�� �޼ҵ�
	public boolean checkName(String name) throws Exception {
		/*
		 * count = people.size(); Person p; //�ε����� ��ȸ�ϸ鼭 ��ü�� ���� for (int i = 0; i <
		 * count; i++) { p = people.get(i); if (name.equals(p.getName())) {// ��ϵ� �̸��� ����
		 * �� true ���� return true; } } return false;
		 */
		Person p = searchName(name);
		if (p == null)
			return false;
		else
			return true;
	}

	public ArrayList<Person> getList() throws Exception { // ����� �����͸� ����Ʈ�� ��ȯ�Ѵ�
		rs = stmt.executeQuery("select name, phoneNum, address, email from addressbook;");
		ArrayList<Person> list = new ArrayList<Person>();
		while (rs.next()) {
			String name = rs.getString("name");
			String phoneNum = rs.getString("phoneNum");
			String address = rs.getString("address");
			String email = rs.getString("email");
			Person p = new Person(name, phoneNum, address, email);
			list.add(p);
		}
		return list;
	}

	// ��ϵ� ��ȭ��ȣ�� �ִ��� Ȯ�� �޼ҵ�
	// public boolean checkPhoneNum(String phoneNum) {
	/*
	 * count = people.size(); Person p; //�ε����� ��ȸ�ϸ鼭 ��ü�� ���� for (int i = 0; i <
	 * count; i++) { p = people.get(i); if (phoneNum.equals(p.getPhoneNum())) {//
	 * ��ϵ� ��ȭ��ȣ�� ���� �� true ���� return true; } } return false;
	 */
	/*
	 * for (Person p: people) { if(phoneNum.equals(p.getPhoneNum())) return true; }
	 * return false; }
	 */

	// �ּҷ� ��� �޼ҵ�
	public void add(Person P) throws Exception {

		// p[count] = P;
		// count++;
		// people.add(P);
		// db�� ����
		String sql = "INSERT INTO addressbook VALUES(?, ?, ?, ?)";
		PreparedStatement ppst = con.prepareStatement(sql);
		ppst.setString(1, P.getName());
		ppst.setString(2, P.getPhoneNum());
		ppst.setString(3, P.getAddress());
		ppst.setString(4, P.getEmail());
		// ���� ����
		ppst.executeUpdate();
	}

	// �̸����� �ּҷ� ��ȣ �˻� �޼ҵ�, ��ϵ� �̸� ���� ��� �ͼ���
	public Person searchName(String name) throws Exception {
		/*
		 * int count = people.size(); Person p; for (int i = 0; i < count; i++) { p =
		 * people.get(i); if (name.equals(p.getName())) {// ��ϵ� �̸��� ���� ��, ȸ����ȣ(�ε��� ��ȣ)����
		 * return i; } }
		 */
		/*
		 * //�Ʒ� �ڵ�� indexOf() �޼ҵ� ������ for���� �� �� ���ƾ� �� �� ���Ƽ� //�� ��ȿ�����̶�� �����ߴ� for (Person
		 * p: people) { if(name.equals(p.getName())) return people.indexOf(p); }
		 */
		String sql = "SELECT * FROM addressbook WHERE name LIKE ?";
		Person p = null;
		PreparedStatement ppst = con.prepareStatement(sql);
		ppst.setString(1, "%" + name + "%");

		rs = ppst.executeQuery();
		if (rs.next()) {
			String target_name = rs.getString("name");
			String target_phoneNum = rs.getString("phoneNum");
			String target_address = rs.getString("address");
			String target_email = rs.getString("email");
			p = new Person(target_name, target_phoneNum, target_address, target_email);

		}
		return p;

	}

	/*
	 * // ��ȭ��ȣ�� �ּҷ� ��ȣ �˻� �޼ҵ�, ��ϵ� ��ȭ��ȣ ���� ��� �ͼ��� public int searchPhoneNum(String
	 * phoneNum) throws Exception { int count = people.size(); Person p; for (int i
	 * = 0; i < count; i++) { p = people.get(i); if
	 * (phoneNum.equals(p.getPhoneNum())) {// ��ϵ� ��ȭ��ȣ ���� ��, ȸ����ȣ(�ε��� ��ȣ)���� return
	 * i; } } /*�Ʒ� �ڵ�� indexOf() �޼ҵ� ������ for���� �� �� ���ƾ� �� �� ���Ƽ� �� ��ȿ�����̶�� �����ߴ� for
	 * (Person p: people) { if (phoneNum.equals(p.getPhoneNum())) return
	 * people.indexOf(p); }
	 */
	/*
	 * throw new Exception("��ϵ� phoneNum ����"); }
	 */

	// �ּҷ� ���� �޼ҵ�
	public void modify(Person P, String name_before) throws Exception {
		// p[index] = P;
		// people.set(index, P);
		PreparedStatement ppst;
		String sql = "UPDATE addressbook SET name=?, phoneNum=?, address=?, email=? WHERE name=?";
		ppst = con.prepareStatement(sql);

		ppst.setString(1, P.getName());
		ppst.setString(2, P.getPhoneNum());
		ppst.setString(3, P.getAddress());
		ppst.setString(4, P.getEmail());
		ppst.setString(5, name_before);

		ppst.executeUpdate();
	}

	// �ּҷ� ���� �޼ҵ�
	public void delete(Person p) throws Exception {
		/*
		 * for (int i = index; i < count; i++) { if (i + 1 == p.length) p[i] = null; //
		 * p�� ũ��(������ �ε���)�� �ش��ϸ�, ������� ��� null else p[i] = p[i + 1]; // ��ü 1���� ������
		 * �̵�(�������) } count--;
		 */
		// people.remove(index);
		String sql = "DELETE From addressbook WHERE name=?";
		PreparedStatement ppst;

		ppst = con.prepareStatement(sql);
		ppst.setString(1, p.getName());

		ppst.executeUpdate();
	}
	/*
	 * // Person ��ü �Ѱ��ִ� �޼ҵ� public Person getPerson(int index) { //return p[index];
	 * return people.get(index); }
	 */
	/*
	 * 
	 * // �����͸� ���Ͽ� �����ϴ� �޼ҵ� public void writeFile(ObjectOutputStream fn) throws
	 * Exception { try {
	 * 
	 * int count = people.size(); fn.writeInt(count); // ��ϵ� ��� �� ���Ͽ� ���� /* Person
	 * p; for (int i = 0; i < count; i++) { try { // persons�迭�� Person ��ü�� �ϳ��� ������
	 * ���� //p[i].writeMyField(fn); p = people.get(i); p.writeMyField(fn); } catch
	 * (Exception e) { throw new Exception("writeFile Exception"); } }
	 */
	/*
	 * for (Person p: people) { try { //p.writeMyField(fn); } catch (Exception e) {
	 * throw new Exception("writeFile Exception"); } }
	 */
	/*
	 * for(Person p: people) { fn.writeObject(p); }
	 * 
	 * } catch (IOException ioe) { throw new IOException("IOException"); } } // �����͸�
	 * ���Ͽ��� �������� �޼ҵ� // �ڷ����� ���� read�Լ��� �ٸ��� ��� public void
	 * readFile(ObjectInputStream fn) throws Exception { /* try { int count =
	 * fn.readInt(); // ��ϵ� ��� �� �����ͼ� count ������ �ֱ� Person p; for (int i = 0; i <
	 * count; i++) { p= new Person(); // read�� ������ ������ Person��ü ����
	 * 
	 * try { // persons�迭�� ��� p.readMyField(fn); people.add(p); } catch (Exception
	 * e) { throw new Exception("readFile Exception"); } } fn.close(); } catch
	 * (EOFException eofe) { throw new Exception("EOFException"); } catch
	 * (IOException ioe) { throw new IOException("IOException"); //����! }
	 */
	/*
	 * try { int count = fn.readInt(); for(int i = 0;i< count; i++) { Person p =
	 * (Person) fn.readObject(); people.add(p); } fn.close(); } catch (EOFException
	 * eofe) { throw new EOFException("EOFException"); } catch (IOException ioe) {
	 * throw new IOException("IOException"); } }
	 */
}
