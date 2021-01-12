package Address;

import java.io.*;
import java.util.*;
import java.lang.Thread.State;
import java.sql.*;

@SuppressWarnings("unused") // 사용하지 않는 코드관련 경고 억제

public class AddressBook {
	// DataOutputStream fOut = null; // 파일 관리 변수중 write에 쓰이는 변수 fOut
	// ObjectInputStream fIn = null; // 파일 관리 변수중 read에 쓰이는 변수 fIn
	// private Person[] p;
	// private ArrayList<Person> people;
	// private int count; // size()를 저장할 변수//로컬로 바꿔야 할 듯...ㅎ
	// db와 연동하기 위해 필요한 변수
	private Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String url;

	// 생성자
	AddressBook(String url, Connection con) throws Exception {
		this.url = url;
		this.con = con;
		getConnection();
	}

	/*
	 * public AddressBook(int num) throws Exception {// UI에서 생성할 사람의 수 가져와서 객체 생성
	 * people = new ArrayList<Person>(num); // p = new Person[num]; }
	 * 
	 * public AddressBook(int num, ObjectInputStream fn) throws Exception {// UI에서
	 * 생성할 사람의 수 가져와서 객체 생성 //fIn = fn; // p = new Person[num];
	 * 
	 * people = new ArrayList<Person>(num); try { readFile(fn); } catch (IOException
	 * e) { throw new IOException("IOException"); } catch (NullPointerException e)
	 * {//??? throw new IOException("NullPointerException"); } }
	 */
	void getConnection() throws ClassNotFoundException, SQLException {
		// 드라이버 로드
		Class.forName("org.mariadb.jdbc.Driver");
		// statement 얻기
		stmt = con.createStatement();
	}

	/*
	 * public int getCount() { // 등록된 사람 수 접근자 // return count; return
	 * people.size(); }
	 */
	// 동명이인 확인 메소드
	public boolean checkName(String name) throws Exception {
		/*
		 * count = people.size(); Person p; //인덱스를 순회하면서 객체를 저장 for (int i = 0; i <
		 * count; i++) { p = people.get(i); if (name.equals(p.getName())) {// 등록된 이름이 있을
		 * 때 true 리턴 return true; } } return false;
		 */
		Person p = searchName(name);
		if (p == null)
			return false;
		else
			return true;
	}

	public ArrayList<Person> getList() throws Exception { // 저장된 데이터를 리스트로 반환한다
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

	// 등록된 전화번호가 있는지 확인 메소드
	// public boolean checkPhoneNum(String phoneNum) {
	/*
	 * count = people.size(); Person p; //인덱스를 순회하면서 객체를 저장 for (int i = 0; i <
	 * count; i++) { p = people.get(i); if (phoneNum.equals(p.getPhoneNum())) {//
	 * 등록된 전화번호가 있을 때 true 리턴 return true; } } return false;
	 */
	/*
	 * for (Person p: people) { if(phoneNum.equals(p.getPhoneNum())) return true; }
	 * return false; }
	 */

	// 주소록 등록 메소드
	public void add(Person P) throws Exception {

		// p[count] = P;
		// count++;
		// people.add(P);
		// db에 저장
		String sql = "INSERT INTO addressbook VALUES(?, ?, ?, ?)";
		PreparedStatement ppst = con.prepareStatement(sql);
		ppst.setString(1, P.getName());
		ppst.setString(2, P.getPhoneNum());
		ppst.setString(3, P.getAddress());
		ppst.setString(4, P.getEmail());
		// 쿼리 수행
		ppst.executeUpdate();
	}

	// 이름으로 주소록 번호 검색 메소드, 등록된 이름 없을 경우 익셉션
	public Person searchName(String name) throws Exception {
		/*
		 * int count = people.size(); Person p; for (int i = 0; i < count; i++) { p =
		 * people.get(i); if (name.equals(p.getName())) {// 등록된 이름이 있을 때, 회원번호(인덱스 번호)리턴
		 * return i; } }
		 */
		/*
		 * //아래 코드는 indexOf() 메소드 때문에 for문을 두 번 돌아야 할 것 같아서 //더 비효율적이라고 생각했다 for (Person
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
	 * // 전화번호로 주소록 번호 검색 메소드, 등록된 전화번호 없을 경우 익셉션 public int searchPhoneNum(String
	 * phoneNum) throws Exception { int count = people.size(); Person p; for (int i
	 * = 0; i < count; i++) { p = people.get(i); if
	 * (phoneNum.equals(p.getPhoneNum())) {// 등록된 전화번호 있을 때, 회원번호(인덱스 번호)리턴 return
	 * i; } } /*아래 코드는 indexOf() 메소드 때문에 for문을 두 번 돌아야 할 것 같아서 더 비효율적이라고 생각했다 for
	 * (Person p: people) { if (phoneNum.equals(p.getPhoneNum())) return
	 * people.indexOf(p); }
	 */
	/*
	 * throw new Exception("등록된 phoneNum 없음"); }
	 */

	// 주소록 수정 메소드
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

	// 주소록 삭제 메소드
	public void delete(Person p) throws Exception {
		/*
		 * for (int i = index; i < count; i++) { if (i + 1 == p.length) p[i] = null; //
		 * p의 크기(마지막 인덱스)에 해당하면, 덧씌우기 대신 null else p[i] = p[i + 1]; // 객체 1개씩 앞으로
		 * 이동(덧씌우기) } count--;
		 */
		// people.remove(index);
		String sql = "DELETE From addressbook WHERE name=?";
		PreparedStatement ppst;

		ppst = con.prepareStatement(sql);
		ppst.setString(1, p.getName());

		ppst.executeUpdate();
	}
	/*
	 * // Person 객체 넘겨주는 메소드 public Person getPerson(int index) { //return p[index];
	 * return people.get(index); }
	 */
	/*
	 * 
	 * // 데이터를 파일에 저장하는 메소드 public void writeFile(ObjectOutputStream fn) throws
	 * Exception { try {
	 * 
	 * int count = people.size(); fn.writeInt(count); // 등록된 사람 수 파일에 저장 /* Person
	 * p; for (int i = 0; i < count; i++) { try { // persons배열낸 Person 객체에 하나씩 접근해
	 * 저장 //p[i].writeMyField(fn); p = people.get(i); p.writeMyField(fn); } catch
	 * (Exception e) { throw new Exception("writeFile Exception"); } }
	 */
	/*
	 * for (Person p: people) { try { //p.writeMyField(fn); } catch (Exception e) {
	 * throw new Exception("writeFile Exception"); } }
	 */
	/*
	 * for(Person p: people) { fn.writeObject(p); }
	 * 
	 * } catch (IOException ioe) { throw new IOException("IOException"); } } // 데이터를
	 * 파일에서 가져오는 메소드 // 자료형에 따라 read함수를 다르게 사용 public void
	 * readFile(ObjectInputStream fn) throws Exception { /* try { int count =
	 * fn.readInt(); // 등록된 사람 수 가져와서 count 변수에 넣기 Person p; for (int i = 0; i <
	 * count; i++) { p= new Person(); // read한 정보를 저장할 Person객체 생성
	 * 
	 * try { // persons배열에 담기 p.readMyField(fn); people.add(p); } catch (Exception
	 * e) { throw new Exception("readFile Exception"); } } fn.close(); } catch
	 * (EOFException eofe) { throw new Exception("EOFException"); } catch
	 * (IOException ioe) { throw new IOException("IOException"); //여기! }
	 */
	/*
	 * try { int count = fn.readInt(); for(int i = 0;i< count; i++) { Person p =
	 * (Person) fn.readObject(); people.add(p); } fn.close(); } catch (EOFException
	 * eofe) { throw new EOFException("EOFException"); } catch (IOException ioe) {
	 * throw new IOException("IOException"); } }
	 */
}
