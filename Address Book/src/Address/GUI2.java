package Address;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI2 extends JFrame {

	private JFrame frame;
	private JTextField searchField;
	private JTable table;

	static AddressBook ad;

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/address";
		try {
			Connection con = DriverManager.getConnection(url, "root", "1013");
			ad = new AddressBook(url, con);
			GUI2 gui = new GUI2();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public GUI2() throws Exception {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("=====주소록 프로그램=====");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 36, 259, 34);
		frame.getContentPane().add(lblNewLabel);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewAddress();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\LG\\Downloads\\free-icon-add-1237946 (1).png"));
		btnAdd.setBounds(735, 10, 27, 34);
		frame.getContentPane().add(btnAdd);

		searchField = new JTextField();
		searchField.setText("검색");
		searchField.setBounds(12, 76, 368, 34);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new SerchListener(searchField));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\LG\\Downloads\\free-icon-loupe-622669.png"));
		btnSearch.setBounds(388, 75, 37, 35);
		frame.getContentPane().add(btnSearch);

		// 전체 주소록 표시
		showAddress();

		frame.setVisible(true);
	}

	public void showAddress() {
		// Person의 필드값
		String[] colName = { "이름", "전화번호", "주소", "이메일" };

		// 연락처를 추가, 삭제의 경우 해당 열을 추가 삭제해야하기 때문에 모델을 선언했다
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		table = new JTable(model);

		// 리스트로 반환받은 객체 모델로 추가
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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 750, 270);
		frame.getContentPane().add(scrollPane);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "프로그램을 종료합니다. 계속하시겠습니까?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					// 사용자가 선택 없이 다이얼로그 창을 닫은 경우
				} else if (result == JOptionPane.YES_OPTION) {
					// 사용자가 예를 선택한 경우
					System.exit(0);
				} else {
					// 사용자가 아니오를 선택한 경우
				}
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Users\\LG\\Downloads\\free-icon-logout-992680.png"));
		btnExit.setBounds(735, 404, 27, 23);
		frame.getContentPane().add(btnExit);
	}

	class NewAddress extends JFrame {// 새 연락처 등록
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
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_NewAddress = new JLabel("==========[새 주소록 등록]==========");
			title_NewAddress.setBounds(120, 0, 370, 38);
			panel.add(title_NewAddress);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 이름 라벨
			JLabel label_name = new JLabel("이름");
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// 이름 입력 텍스트 필드
			name_textField = new JTextField();
			name_textField.setBounds(172, 14, 331, 31);
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// 전화번호 라벨
			JLabel label_phoneNum = new JLabel("전화번호");
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// 전화번호 입력 텍스트 필드
			phoneNum_textField = new JTextField();
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// 주소 라벨
			JLabel label_address = new JLabel("주소");
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// 주소 입력 텍스트 필드
			address_textField = new JTextField();
			address_textField.setColumns(10);
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// 이메일 라벨
			JLabel label_email = new JLabel("이메일");
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// 이메일 입력 텍스트 필드
			email_textField = new JTextField();
			email_textField.setColumns(10);
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// 등록 버튼
			JButton button = new JButton("등록");
			// 클릭 이벤트가 발생하면 이벤트 실행(이벤트 설명은 하단에)
			button.addActionListener(
					new TryAddListener(name_textField, phoneNum_textField, address_textField, email_textField));
			button.setBackground(SystemColor.controlHighlight);
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
			JTextField text_name, text_number, text_address, text_email;

			TryAddListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email) {
				// 필드값을 받기 위해 각각의 컴포넌트를 가져온다
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
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
					JOptionPane.showMessageDialog(null, "이름은 필수 입력 요소입니다");
				}
				if (checkName) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 연락처 입니다");
				} else {
					// 중복되는 연락처가 아니라면 위에서 받은 Person의 필드값으로 Person 객체를 만든다
					Person p = new Person(name, phoneNum, address, email);
					try {
						// address book의 arrayList에 추가한다
						// 이제 arrayList가 아니라 db에 저장한다
						ad.add(p);
						showAddress();
						JOptionPane.showMessageDialog(null, "등록되었습니다");
						// 등록이 끝났다면 메인메뉴로 돌아갈 수 있는 홈 버튼을 보이도록 한다
						frame.dispose();
					} catch (Exception ex) {
						ex.getMessage();
					}
				}
			}

		}
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
				new search(p);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "검색결과가 존재하지 않습니다");
			}

		}
	}

	class search extends JFrame {
		private JFrame frame;
		Person p;

		// 메인화면에서 검색한 결과(Person 객체와 그 인덱스)를 가져온다
		public search(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			// 프레임 생성
			frame = new JFrame("연락처 검색");
			frame.setBounds(100, 100, 639, 416);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[주소록 검색]==========");
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
			scrollPane.setViewportView(table);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 71);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 수정버튼
			JButton button_modify = new JButton("수정");
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
			button_delete.setBackground(SystemColor.controlHighlight);
			// 리스너: 삭제버튼을 누르면 바로 삭제되지 않고 경고창으로 다시 한번 더 물어보기 위해 경고창을 띄운다
			button_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "선택한 주소록이 삭제됩니다. 계속하시겠습니까?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// 사용자가 선택 없이 다이얼로그 창을 닫은 경우
					} else if (result == JOptionPane.YES_OPTION) {
						// 사용자가 예를 선택한 경우
						try {
							ad.delete(p);
							showAddress();
							frame.dispose();
						} catch (Exception e1) {
							e1.getMessage();
						}
					} else {
						// 사용자가 아니오를 선택한 경우
					}
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
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// 이름 라벨
			JLabel label_name = new JLabel("이름");
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// 이름 입력 텍스트 필드: 기존에 저장되어있던 이름을 넣어 놓았다
			name_textField = new JTextField(p.getName());
			name_textField.setBounds(172, 14, 331, 31);
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// 전화번호 라벨
			JLabel label_phoneNum = new JLabel("전화번호");
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// 전화번호 입력 텍스트 필드: 기존에 저장되어있던 전화번호를 넣어 놓았다
			phoneNum_textField = new JTextField(p.getPhoneNum());
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// 주소 라벨
			JLabel label_address = new JLabel("주소");
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// 주소 입력 텍스트 필드: 기존에 저장되어있던 주소를 넣어 놓았다
			address_textField = new JTextField(p.getAddress());
			address_textField.setColumns(10);
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// 이메일 라벨
			JLabel label_email = new JLabel("이메일");
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// 이메일 입력 텍스트 필드: 기존에 저장되어있던 이메일을 넣어 놓았다
			email_textField = new JTextField(p.getEmail());
			email_textField.setColumns(10);
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// 수정 버튼
			JButton button_modify = new JButton("수정");
			button_modify.setBackground(SystemColor.controlHighlight);
			button_modify.setBounds(498, 10, 91, 42);
			panel_2.add(button_modify);
			button_modify.addActionListener(
					new ModifyButtonListener(name_textField, phoneNum_textField, address_textField, email_textField));

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
			JTextField text_name, text_number, text_address, text_email;

			ModifyButtonListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email) {
				// 필드값을 받기 위해 각각의 컴포넌트를 가져온다
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
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
						JOptionPane.showMessageDialog(null, "정상적으로 수정되었습니다");
						showAddress();
						frame.dispose();
					} catch (Exception ex) {
						// System.out.println("등록 가능 인원 수가 초과되었습니다.");
					}
				}
				// 이름을 입력하지 않았다면
				else if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "이름은 필수 입력 요소입니다");
				} else if (checkName) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 연락처입니다");
				} else {
					// 중복되는 연락처가 아니라면 위에서 받은 Person의 필드값으로 Person 객체를 만든다
					Person p = new Person(name, phoneNum, address, email);
					try {
						// 해당 연락처를 수정한다
						ad.modify(p, name_before);
						JOptionPane.showMessageDialog(null, "정상적으로 수정되었습니다");
						showAddress();
						frame.dispose();
					} catch (Exception ex) {
						// System.out.println("등록 가능 인원 수가 초과되었습니다.");
					}
				}

			}

		}
	}

}
