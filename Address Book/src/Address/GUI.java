package Address;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

import java.lang.Thread.State;
import java.sql.*;
import java.util.ArrayList;

public class GUI extends JFrame {

	//AddressBook ad;

	// address book의 메소드와 필드 사용을 위해 파라미터로 받아온다
	/*
	public GUI() throws Exception{
		initialize();
		ad = new AddressBook();
	}*/

	/*
	public static void main(String[] args) {
		// 이제 필요 없음
		// ObjectInputStream in = null;
		// ObjectOutputStream out = null;

		// AddressBook ad = new AddressBook();
		/*
		 * try { //저장된 파일 읽어오기 in = new ObjectInputStream(new
		 * FileInputStream("addressbook.dat")); ad = new AddressBook(100, in);
		 * in.close(); } catch (FileNotFoundException fnfe) { try { //처음 실행한다면 새로 주소록
		 * 만들기 ad = new AddressBook(100); } catch (Exception e) { } } catch (Exception
		 * ex) { }
		 */
	/*
		// 읽어온 address book을 매개변수로 넘겨준다
		try {	
			GUI gui = new GUI();
		} catch (Exception e) {
			e.getMessage();
		}
	}*/
/*
	private void initialize() { // 메인 메뉴 생성
		// 프레임 생성
		JFrame frame = new JFrame("주소록 프로그램");
		frame.setFont(new Font("THE외계인설명서", Font.BOLD, 15));
		frame.setBounds(100, 100, 684, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 646, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// 이름으로 검색하기 위한 텍스트 핃드
		JTextField serchField = new JTextField();
		serchField.setHorizontalAlignment(SwingConstants.CENTER);
		serchField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
		serchField.setText("이름으로 검색");
		serchField.setBounds(12, 10, 527, 42);
		panel.add(serchField);
		serchField.setColumns(10);

		// 검색 버튼
		// 텍스트로 "검색" 써 있는 것 보다 돋보기 이미지로 나타내는게 더 눈에 잘 띌 것 같아서 이미지 아이콘을 넣었다
		JButton serchButton = new JButton();
		serchButton.setIcon(new ImageIcon(
				"C:\\\uC11C\uC6B8\uC5EC\uB300\\2020 2\uD559\uAE30\\javaWork\\Address Book\\magnify glass.png"));
		serchButton.setBackground(SystemColor.controlHighlight);
		// 리스너: 클릭이벤트가 발생하면 위의 텍스트 필드값을 이름으로 간주하여 검색하는 창을 연다
		serchButton.addActionListener(new SerchListener(serchField));
		serchButton.setBounds(543, 10, 91, 42);
		panel.add(serchButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 82, 646, 269);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		// 메뉴 1: 새 주소록 등록
		JButton add_Button = new JButton("새 주소록 등록");
		// 리스너: 클릭 이벤트가 발생하면 주소록 등록 창(새 창)을 연다
		add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewAddress();
			}
		});
		add_Button.setBackground(SystemColor.controlHighlight);
		add_Button.setFont(new Font("THE외계인설명서", Font.BOLD, 30));
		add_Button.setBounds(12, 30, 293, 77);
		panel_1.add(add_Button);

		// 메뉴 2: 전체 주소록 조회
		JButton view_Button = new JButton("전체 주소록 조회");
		view_Button.setBackground(SystemColor.controlHighlight);
		view_Button.setFont(new Font("THE외계인설명서", Font.BOLD, 30));
		// 리스너: 클릭 이벤트가 발생하면 전체 주소록 조회창(새 창)을 연다
		view_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new All();
			}
		});
		view_Button.setBounds(341, 30, 293, 77);
		panel_1.add(view_Button);

		/*
		 * //메뉴 3: 주소록 파일로 저장 JButton save_Button = new JButton("주소록 저장"); //리스너: 클릭이벤트가
		 * 발생하면 저장화면을 연다 save_Button.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent e) { new Save(); } });
		 * save_Button.setBackground(SystemColor.controlHighlight);
		 * save_Button.setFont(new Font("THE외계인설명서", Font.BOLD, 30));
		 * save_Button.setBounds(12, 162, 293, 77); panel_1.add(save_Button);
		 */
/*
		// 메뉴 4: 프로그램 종료
		JButton exit_Button = new JButton("프로그램 종료");
		exit_Button.setBounds(341, 162, 293, 77);
		panel_1.add(exit_Button);
		// 리스너: 클릭이벤트가 발생하면 저장하고 종료하라는 경고 메시지 창을 띄운다
		exit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Exit();
			}
		});
		exit_Button.setBackground(SystemColor.controlHighlight);
		exit_Button.setFont(new Font("THE외계인설명서", Font.BOLD, 30));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 361, 646, 88);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// 수정 삭제 메뉴는 주소록을 검색하여 그에 대한 검색 결과가 나온 창에서 할 수 있도록 구현할 것이다 => 메인 메뉴에는 없음

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	class SerchListener implements ActionListener {
		JTextField serchField;

		// 메인 화면의 텍스트 필드를 가져온다
		SerchListener(JTextField serchField) {
			this.serchField = serchField;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 사용자가 입력한 이름을 받아온다
			String name = serchField.getText();
			// Address Book의 searchName이 인덱스를 반환하기 때문에 그 인덱스를 저장할 변수와 사람을 저장할 변수
			int target_index;
			Person p;
			try {
				// 이름을 찾아서 그 인덱스를 저장한다
				// target_index = ad.searchName(name);
				// p = ad.getPerson(target_index);
				// serchName은 바로 p를 리턴하므로 수정함
				p = ad.searchName(name);
				// 검색한 결과를 다음 화면으로 보여준다
				new serch(p);
			} catch (Exception e1) {
				new NameNotFound();
			}

		}
	}

	class NewAddress extends JFrame { // 새 연락처 등록 창

		private JFrame frame;
		private JTextField name_textField;
		private JTextField phoneNum_textField;
		private JTextField address_textField;
		private JTextField email_textField;

		public NewAddress() {
			initialize();
		}

		private void initialize() {
			// 프레임 생성
			frame = new JFrame("새 주소록 등록");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_NewAddress = new JLabel("==========[새 주소록 등록]==========");
			title_NewAddress.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_NewAddress.setBounds(120, 0, 370, 38);
			panel.add(title_NewAddress);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 이름 라벨
			JLabel label_name = new JLabel("이름");
			label_name.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// 이름 입력 텍스트 필드
			name_textField = new JTextField();
			name_textField.setBounds(172, 14, 331, 31);
			name_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// 전화번호 라벨
			JLabel label_phoneNum = new JLabel("전화번호");
			label_phoneNum.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// 전화번호 입력 텍스트 필드
			phoneNum_textField = new JTextField();
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// 주소 라벨
			JLabel label_address = new JLabel("주소");
			label_address.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// 주소 입력 텍스트 필드
			address_textField = new JTextField();
			address_textField.setColumns(10);
			address_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// 이메일 라벨
			JLabel label_email = new JLabel("이메일");
			label_email.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// 이메일 입력 텍스트 필드
			email_textField = new JTextField();
			email_textField.setColumns(10);
			email_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// 사용자가 등록 버튼을 눌렀을 때 나오는 메시지1
			JLabel message_error = new JLabel("이미 존재하는 연락처 입니다");
			message_error.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_error.setBounds(309, 13, 179, 37);
			panel_2.add(message_error);
			// 사용자가 등록 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_error.setVisible(false);

			// 사용자가 등록 버튼을 눌렀을 때 나오는 메시지2
			JLabel message_success = new JLabel("연락처가 정상적으로 등록되었습니다");
			message_success.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_success.setBounds(235, 10, 251, 42);
			panel_2.add(message_success);
			// 사용자가 등록 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_success.setVisible(false);

			// 사용자가 등록 버튼을 눌렀을 때 나오는 메시지3
			JLabel message_noname = new JLabel("이름은 필수 입력 요소입니다");
			message_noname.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_noname.setBounds(235, 10, 251, 42);
			panel_2.add(message_noname);
			// 사용자가 등록 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_noname.setVisible(false);

			// 사용자의 연락처 등록이 끝난 후 생길 버튼
			JButton home = new JButton("홈");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// 클릭 시 메인메뉴 화면으로 돌아가기 위한 이벤트 리스너
			home.addActionListener(new ToHome());
			panel_2.add(home);
			// 사용자가 등록 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			home.setVisible(false);

			// 등록 버튼
			JButton button = new JButton("등록");
			// 클릭 이벤트가 발생하면 이벤트 실행(이벤트 설명은 하단에)
			button.addActionListener(new TryAddListener(name_textField, phoneNum_textField, address_textField,
					email_textField, message_error, message_success, home, message_noname));
			button.setBackground(SystemColor.controlHighlight);
			button.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button.setBounds(498, 10, 91, 42);
			panel_2.add(button);

			frame.setVisible(true);
		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 현재의 서브 프레임만 종료하여 메인메뉴로 돌아가도록 한다
				frame.dispose();
			}

		}

		class TryAddListener implements ActionListener {// 등록 버튼을 누르면 연락처를 등록하는 리스너 실행
			JLabel message_error, message_success, message_noname;
			JTextField text_name, text_number, text_address, text_email;
			JButton home;

			TryAddListener(JTextField text_name, JTextField text_number, JTextField text_address, JTextField text_email,
					JLabel message_error, JLabel message_success, JButton home, JLabel message_noname) {
				// 필드값을 받기 위해 각각의 컴포넌트를 가져온다
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
				this.message_error = message_error;
				this.message_success = message_success;
				this.home = home;
				this.message_noname = message_noname;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// 등록을 위해 받아온 컴포넌트들의 필드값을 Person의 필드값으로 넣어준다
				String name, phoneNum, address, email;
				name = text_name.getText();
				phoneNum = text_number.getText();
				address = text_address.getText();
				email = text_email.getText();
				
				boolean checkName = false;
				try {
					checkName = ad.checkName(name);
				} catch (Exception ex) {
					ex.getMessage();
				}

				// 이름을 입력하지 않았다면
				if (name.equals("")) {
					// 이름은 필수 입력요소라는 메시지를 출력한다.
					message_noname.setVisible(true);
					// 사용자가 실수로 등록 버튼을 누르면 다른 메시지는 보이지 않아야 하므로 안보이도록 설정한다.
					message_success.setVisible(false);
					message_error.setVisible(false);
				}
				if (checkName) {
					// 중복이라면 중복 메시지를 출력한다
					message_error.setVisible(true);
					// 사용자가 실수로 등록 버튼을 한 번 더 누르게 되면 등록 성공 메시지와 겹쳐서 등록 성공 메시지는 다시 안보이도록 설정했다
					message_success.setVisible(false);
					message_noname.setVisible(false);
				} else {
					// 중복되는 연락처가 아니라면 위에서 받은 Person의 필드값으로 Person 객체를 만든다
					Person p = new Person(name, phoneNum, address, email);
					try {
						// address book의 arrayList에 추가한다
						// 이제 arrayList가 아니라 db에 저장한다
						ad.add(p);
						// 등록 성공 메시지를 출력한다
						message_success.setVisible(true);
						// 혹시 이전에 등록하려던 주소록이 중복검사를 통과하지 못해서 수정해서 다시 등록하는 경우 메시지가 겹쳐 중복 메시지는안보이도록 설정했다
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// 등록이 끝났다면 메인메뉴로 돌아갈 수 있는 홈 버튼을 보이도록 한다
						home.setVisible(true);
					} catch (Exception ex) {
						ex.getMessage();
					}
				}
			}

		}
	}

	class All extends JFrame { // 주소록 전체 조회 창

		JFrame frame;

		public All() {
			initialize();
		}

		private void initialize() {
			// 프레임 생성
			frame = new JFrame("전체 주소록 조회");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 40);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_view = new JLabel("==========[전체 주소록 조회]==========");
			title_view.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_view.setBounds(114, 0, 410, 40);
			panel.add(title_view);

			// Person의 필드값
			String[] colName = { "이름", "전화번호", "주소", "이메일" };

			// 연락처를 추가, 삭제의 경우 해당 열을 추가 삭제해야하기 때문에 모델을 선언했다
			DefaultTableModel model = new DefaultTableModel(colName, 0);
			JTable table = new JTable(model);
			/*
			 * //기존에 저장된 주소록이 있다면 저장된 연락처 개수만큼 반복문 실행 int c = ad.getCount(); //Person 객체의
			 * 데이터를 열로 만들 변수 Object[] data; Person p; for(int i = 0; i < c; i++) { p =
			 * ad.getPerson(i); data = new Object[] {p.getName(), p.getPhoneNum(),
			 * p.getAddress(), p.getEmail()}; model.addRow(data); }
			 */
			// 리스트로 반환받은 객체 모델로 추가
	/*
			ArrayList<Person> list = new ArrayList<Person>();
			try {
				list = ad.getList();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Object[] data;
			for (Person p : list) {
				data = new Object[] { p.getName(), p.getPhoneNum(), p.getAddress(), p.getEmail() };
				model.addRow(data);
			}
			table.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(12, 62, 601, 256);
			frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

			frame.getContentPane().add(scrollPane);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 326, 601, 53);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 전체 주소록 확인이 끝났다면 현재 서브 프레임을 종료할 버튼
			JButton home = new JButton("홈");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// 클릭 이벤트: 메인메뉴로 돌아가기
			home.addActionListener(new ToHome());
			panel_1.add(home);

			frame.setVisible(true);

		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭 이벤트 발생 시 현재의 서브프레임 창을 종료한다.
				frame.dispose();
			}

		}
	}

	class serch extends JFrame { // 검색화면

		private JFrame frame;
		Person p;

		// 메인화면에서 검색한 결과(Person 객체와 그 인덱스)를 가져온다
		public serch(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			// 프레임 생성
			frame = new JFrame("연락처 검색");
			frame.setBounds(100, 100, 639, 416);
			// 서브 창에서 X를 누른다고 프로그램이 종료되면 안되기 때문에 아래는 주석처리했다
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[주소록 검색]==========");
			title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 161, 601, 63);
			frame.getContentPane().add(scrollPane);

			// search를 통해 찾은 사람
			this.p = p;

			// Person의 필드값
			String[] colName = { "이름", "전화번호", "주소", "이메일" };

			// 테이블에 들어갈 데이터 값
			Object[][] data = { { p.getName(), p.getPhoneNum(), p.getAddress(), p.getEmail() } };

			// 데이터를 테이블로 그린다
			// 이름으로 검색했고, 이름은 중복되지 않게 했으므로 데이터가 추가되지 않아서 모델을 사용하지 않고 바로 그렸다
			JTable table = new JTable(data, colName);
			table.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			scrollPane.setViewportView(table);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 71);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 수정버튼
			JButton button_modify = new JButton("수정");
			button_modify.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_modify.setBackground(SystemColor.controlHighlight);
			// 리스너: 수정버튼을 누르면 수정하는 화면을 띄운다
			button_modify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Modify(p);
				}
			});
			button_modify.setBounds(0, 29, 91, 42);
			panel_1.add(button_modify);

			// 삭제버튼
			JButton button_delete = new JButton("삭제");
			button_delete.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_delete.setBackground(SystemColor.controlHighlight);
			// 리스너: 삭제버튼을 누르면 바로 삭제되지 않고 경고창으로 다시 한번 더 물어보기 위해 경고창을 띄운다
			button_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Delete(p);
				}
			});
			button_delete.setBounds(510, 29, 91, 42);
			panel_1.add(button_delete);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 320, 601, 49);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// 확인버튼: 현재화면(서브화면)을 종료한다
			JButton button_home = new JButton("확인");
			button_home.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_home.setBackground(SystemColor.controlHighlight);
			button_home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 현재 화면만 종료
					frame.dispose();
				}
			});
			button_home.setBounds(510, 0, 91, 42);
			panel_2.add(button_home);

			frame.setVisible(true);
		}
	}

	class Modify extends JFrame { // 수정화면

		private JTextField name_textField;
		private JTextField phoneNum_textField;
		private JTextField address_textField;
		private JTextField email_textField;
		Person p;
		String name_before; // 수정전 이름을 확인하기 위해 사용(중복검사에 걸리지 않도록)

		private JFrame frame;

		// Address Book의 modify함수가 Person객체와 인덱스를 둘 다 받아서 search에서부터 찾아놓은 객체와 인덱스를 받아온다
		public Modify(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			this.p = p;
			name_before = p.getName();
			// 프레임 생성
			frame = new JFrame("주소록 수정");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[주소록 수정]==========");
			title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 이름 라벨
			JLabel label_name = new JLabel("이름");
			label_name.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// 이름 입력 텍스트 필드: 기존에 저장되어있던 이름을 넣어 놓았다
			name_textField = new JTextField(p.getName());
			name_textField.setBounds(172, 14, 331, 31);
			name_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// 전화번호 라벨
			JLabel label_phoneNum = new JLabel("전화번호");
			label_phoneNum.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// 전화번호 입력 텍스트 필드: 기존에 저장되어있던 전화번호를 넣어 놓았다
			phoneNum_textField = new JTextField(p.getPhoneNum());
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// 주소 라벨
			JLabel label_address = new JLabel("주소");
			label_address.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// 주소 입력 텍스트 필드: 기존에 저장되어있던 주소를 넣어 놓았다
			address_textField = new JTextField(p.getAddress());
			address_textField.setColumns(10);
			address_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// 이메일 라벨
			JLabel label_email = new JLabel("이메일");
			label_email.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// 이메일 입력 텍스트 필드: 기존에 저장되어있던 이메일을 넣어 놓았다
			email_textField = new JTextField(p.getEmail());
			email_textField.setColumns(10);
			email_textField.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// 사용자가 입력한 이름이 중복된 이름일 경우 표시할 메시지
			JLabel message_error = new JLabel("이미 존재하는 연락처 입니다");
			message_error.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_error.setBounds(309, 13, 179, 37);
			panel_2.add(message_error);
			// 사용자가 수정 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_error.setVisible(false);

			// 정상적으로 수정된 경우 표시할 메시지
			JLabel message_success = new JLabel("연락처가 정상적으로 수정되었습니다");
			message_success.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_success.setBounds(235, 10, 251, 42);
			panel_2.add(message_success);
			// 사용자가 수정 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_success.setVisible(false);

			// 이름을 입력하지 않은 경우 표시할 메시지
			JLabel message_noname = new JLabel("이름은 필수 입력 요소입니다");
			message_noname.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			message_noname.setBounds(235, 10, 251, 42);
			panel_2.add(message_noname);
			// 사용자가 수정 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			message_noname.setVisible(false);

			// 사용자의 연락처 수정이 끝난 후 생길 버튼
			JButton home = new JButton("홈");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// 클릭 시 메인메뉴 화면으로 돌아가기 위한 이벤트 리스너
			home.addActionListener(new ToHome());
			panel_2.add(home);
			// 사용자가 등록 버튼을 누르고 나서의 결과값이기 때문에 우선은 보이지 않도록 설정
			home.setVisible(false);

			// 수정 버튼
			JButton button_modify = new JButton("수정");
			button_modify.setBackground(SystemColor.controlHighlight);
			button_modify.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_modify.setBounds(498, 10, 91, 42);
			panel_2.add(button_modify);
			button_modify.addActionListener(new ModifyButtonListener(name_textField, phoneNum_textField,
					address_textField, email_textField, message_error, message_success, home, message_noname));

			frame.setVisible(true);
		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭 이벤트 발생 시 현재의 서브프레임 창을 종료한다.
				frame.dispose();
			}

		}

		class ModifyButtonListener implements ActionListener {
			JLabel message_error, message_success, message_noname;
			JTextField text_name, text_number, text_address, text_email;
			JButton home;

			ModifyButtonListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email, JLabel message_error, JLabel message_success, JButton home,
					JLabel message_noname) {
				// 필드값을 받기 위해 각각의 컴포넌트를 가져온다
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
				this.message_error = message_error;
				this.message_success = message_success;
				this.home = home;
				this.message_noname = message_noname;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// 등록을 위해 받아온 컴포넌트들의 필드값을 Person의 필드값으로 넣어준다
				String name, phoneNum, address, email;
				name = text_name.getText();
				phoneNum = text_number.getText();
				address = text_address.getText();
				email = text_email.getText();
				
				boolean checkName = false;
				try {
					checkName = ad.checkName(name);
				} catch (Exception ex) {
					ex.getMessage();
				}

				if (name.equals(name_before)) {
					// 사용자가 이름을 수정하지 않을 수 있는데, 아래처럼 중복검사를 해 버리면 이미 등록된 연락처로 체크된다
					// 따라서 위에서 수정 전 이름을 저장했다가 만약 지금 액션이벤트로 받아온 이름과 비교해서 같을 경우, 즉 이름을 수정하지 않고 다른 필드를
					// 수정했을 경우에도
					// 수정을 해야 한다
					Person p = new Person(name, phoneNum, address, email);
					try {
						// 해당 연락처를 수정한다
						ad.modify(p, name_before);
						// 등록 성공 메시지를 출력한다
						message_success.setVisible(true);
						// 혹시 이전에 등록하려던 주소록이 중복검사를 통과하지 못해서 수정해서 다시 등록하는 경우
						// 메시지가 겹쳐 중복 메시지는안보이도록 설정했다
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// 등록이 끝났다면 메인메뉴로 돌아갈 수 있는 홈 버튼을 보이도록 한다
						home.setVisible(true);
					} catch (Exception ex) {
						// System.out.println("등록 가능 인원 수가 초과되었습니다.");
					}
				}
				// 이름을 입력하지 않았다면
				else if (name.equals("")) {
					// 이름은 필수 입력요소라는 메시지를 출력한다.
					message_noname.setVisible(true);
					// 사용자가 실수로 등록 버튼을 누르면 다른 메시지는 보이지 않아야 하므로 안보이도록 설정한다.
					message_success.setVisible(false);
					message_error.setVisible(false);
				}
				else if (checkName) {
					// 중복이라면 중복 메시지를 출력한다
					message_error.setVisible(true);
					// 사용자가 실수로 등록 버튼을 한 번 더 누르게 되면 등록 성공 메시지와 겹쳐서 등록 성공 메시지는 다시 안보이도록 설정했다
					message_success.setVisible(false);
					message_noname.setVisible(false);
				} else {
					// 중복되는 연락처가 아니라면 위에서 받은 Person의 필드값으로 Person 객체를 만든다
					Person p = new Person(name, phoneNum, address, email);
					try {
						// 해당 연락처를 수정한다
						ad.modify(p, name_before);
						// 등록 성공 메시지를 출력한다
						message_success.setVisible(true);
						// 혹시 이전에 등록하려던 주소록이 중복검사를 통과하지 못해서 수정해서 다시 등록하는 경우 메시지가 겹쳐 중복 메시지는안보이도록 설정했다
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// 등록이 끝났다면 메인메뉴로 돌아갈 수 있는 홈 버튼을 보이도록 한다
						home.setVisible(true);
					} catch (Exception ex) {
						// System.out.println("등록 가능 인원 수가 초과되었습니다.");
					}
				}

			}

		}
	}

	class Delete extends JFrame { // 사용자에게 정말로 삭제할건지 다시 물어본다

		private JFrame frame;

		// 해당 주소록만 삭제해야 하기 때문에 search에서 찾은 Person 객체와 객체의 인덱스를 받아온다
		public Delete(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			// 프레임 생성
			frame = new JFrame("주소록 삭제");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[주소록 삭제]==========");
			title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 311);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("선택한 주소록이 삭제됩니다");
			lblNewLabel.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel.setBounds(207, 78, 180, 30);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("계속하시겠습니까?");
			lblNewLabel_1.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(231, 111, 127, 30);
			panel_1.add(lblNewLabel_1);

			JButton button_yes = new JButton("예");
			button_yes.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_yes.setBounds(69, 221, 91, 42);
			button_yes.setBackground(SystemColor.controlHighlight);
			panel_1.add(button_yes);
			// 리스너: 사용자가 예 버튼을 눌러야 해당 주소록을 삭제한다
			button_yes.addActionListener(new YesButtonListener(p));

			JButton button_no = new JButton("아니오");
			button_no.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_no.setBounds(428, 221, 91, 42);
			button_no.setBackground(SystemColor.controlHighlight);
			// 리스너: 현재 창(서브프레임)을 종료한다
			button_no.addActionListener(new NoButtonListener());
			panel_1.add(button_no);

			frame.setVisible(true);
		}

		class YesButtonListener implements ActionListener {
			Person p = null;
			int index;

			YesButtonListener(Person p) {
				this.p = p;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ad.delete(p);
				} catch (Exception e1) {
					e1.getMessage();
				}
				frame.dispose();
			}

		}

		class NoButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		}

	}

	/*
	 * class Save extends JFrame{//주소록 파일 저장
	 * 
	 * private JFrame frame;
	 * 
	 * public Save() { initialize(); }
	 * 
	 * private void initialize() { // 프레임 생성 frame = new JFrame("주소록 저장");
	 * frame.setBounds(100, 100, 639, 416);
	 * //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.getContentPane().setLayout(null);
	 * 
	 * JPanel panel = new JPanel(); panel.setBounds(12, 10, 601, 38);
	 * frame.getContentPane().add(panel); panel.setLayout(null);
	 * 
	 * JLabel title_Serch = new JLabel("==========[주소록 저장]==========");
	 * title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
	 * title_Serch.setBounds(120, 0, 370, 38); panel.add(title_Serch);
	 * frame.getContentPane().add(panel);
	 * 
	 * JPanel panel_1 = new JPanel(); panel_1.setBounds(12, 71, 601, 240);
	 * frame.getContentPane().add(panel_1); panel_1.setLayout(null);
	 * 
	 * JLabel lblNewLabel = new JLabel("지금까지 등록된 연락처를 파일로 저장합니다");
	 * lblNewLabel.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
	 * lblNewLabel.setBounds(150, 60, 290, 48); panel_1.add(lblNewLabel);
	 * 
	 * JLabel lblNewLabel_1 = new JLabel("계속하시겠습니까?"); lblNewLabel_1.setFont(new
	 * Font("THE외계인설명서", Font.PLAIN, 15)); lblNewLabel_1.setBounds(229, 96, 155,
	 * 48); panel_1.add(lblNewLabel_1);
	 * 
	 * JButton button_yes = new JButton("예"); button_yes.setFont(new
	 * Font("THE외계인설명서", Font.PLAIN, 15)); button_yes.setBounds(72, 190, 91, 42);
	 * button_yes.setBackground(SystemColor.controlHighlight); //리스너: 사용자가 예를 누르면
	 * 파일로 주소록을 저장한다 button_yes.addActionListener(new YesButtonListener());
	 * panel_1.add(button_yes);
	 * 
	 * JButton button_no = new JButton("아니오"); button_no.setFont(new
	 * Font("THE외계인설명서", Font.PLAIN, 15)); button_no.setBounds(434, 190, 91, 42);
	 * button_no.setBackground(SystemColor.controlHighlight); //리스너: 현재창(서브프레임)을
	 * 종료한다 button_no.addActionListener(new NoButtonListener());
	 * panel_1.add(button_no);
	 * 
	 * frame.setVisible(true);
	 * 
	 * }
	 * 
	 * class YesButtonListener implements ActionListener { ObjectOutputStream out;
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { try { out = new
	 * ObjectOutputStream(new FileOutputStream("addressbook.dat"));
	 * ad.writeFile(out); //System.out.println("저장되었습니다."); } catch
	 * (FileNotFoundException fnfe) { //System.out.println(fnfe.getMessage()); }
	 * catch (IOException ioe) { //System.out.println("저장을 실패했습니다."); } catch
	 * (Exception ex) {
	 * 
	 * } finally { // close()이용해 out에 연결된 참조값을 끊기 try { out.close(); } catch
	 * (IOException ex) { //System.out.println(ex.getMessage()); } catch (Exception
	 * ex) { //System.out.println(ex.getMessage()); } frame.dispose(); } }
	 * 
	 * } class NoButtonListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { frame.dispose(); }
	 * 
	 * } }
	 */
/*
	class NameNotFound extends JFrame { // 검색에서 이름을 찾지 못했을 경우

		private JFrame frame;

		public NameNotFound() {
			initialize();
		}

		private void initialize() {
			// 프레임 생성
			frame = new JFrame("연락처 검색");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[주소록 검색]==========");
			title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 71, 601, 240);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("등록된 주소록이 없습니다");
			lblNewLabel.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel.setBounds(215, 61, 155, 48);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("메인화면으로 돌아갑니다");
			lblNewLabel_1.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(215, 97, 155, 48);
			panel_1.add(lblNewLabel_1);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 323, 601, 46);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			JButton button_ok = new JButton("확인");
			button_ok.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_ok.setBounds(510, 0, 91, 42);
			button_ok.setBackground(SystemColor.controlHighlight);
			// 리스너: 확인버튼을 누르면 현재창을 종료한다
			button_ok.addActionListener(new ToHome());
			panel_2.add(button_ok);

			frame.setVisible(true);
		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭 이벤트 발생 시 현재의 서브프레임 창을 종료한다.
				frame.dispose();
			}

		}
	}

	class Exit extends JFrame { // 프로그램 종료 버튼을 누르면 사용자가 저장을 했는지 한 번더 확인할 수 있도록 알려주는 경고창

		private JFrame frame;

		public Exit() {
			initialize();
		}

		private void initialize() {
			// 프레임 생성
			frame = new JFrame("프로그램 종료");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[프로그램 종료]==========");
			title_Serch.setFont(new Font("THE외계인설명서", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 311);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("프로그램을 종료합니다");
			lblNewLabel.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel.setBounds(226, 88, 148, 33);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_2 = new JLabel("계속하시겠습니까?");
			lblNewLabel_2.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(237, 141, 124, 33);
			panel_1.add(lblNewLabel_2);

			JButton button_yes = new JButton("예");
			button_yes.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_yes.setBounds(90, 213, 91, 42);
			button_yes.addActionListener(new YesButtonListener());
			button_yes.setBackground(SystemColor.controlHighlight);
			panel_1.add(button_yes);

			JButton button_no = new JButton("아니오");
			button_no.setFont(new Font("THE외계인설명서", Font.PLAIN, 15));
			button_no.setBackground(SystemColor.controlHighlight);
			button_no.setBounds(432, 213, 91, 42);
			// 리스너: 아니오 버튼을 누르면 현재창을 종료한다
			button_no.addActionListener(new NoButtonListener());
			panel_1.add(button_no);

			frame.setVisible(true);
		}

		class YesButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		}

		class NoButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		}
	}
*/
}
