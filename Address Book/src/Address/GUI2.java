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

		JLabel lblNewLabel = new JLabel("=====�ּҷ� ���α׷�=====");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
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
		searchField.setText("�˻�");
		searchField.setBounds(12, 76, 368, 34);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new SerchListener(searchField));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\LG\\Downloads\\free-icon-loupe-622669.png"));
		btnSearch.setBounds(388, 75, 37, 35);
		frame.getContentPane().add(btnSearch);

		// ��ü �ּҷ� ǥ��
		showAddress();

		frame.setVisible(true);
	}

	public void showAddress() {
		// Person�� �ʵ尪
		String[] colName = { "�̸�", "��ȭ��ȣ", "�ּ�", "�̸���" };

		// ����ó�� �߰�, ������ ��� �ش� ���� �߰� �����ؾ��ϱ� ������ ���� �����ߴ�
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		table = new JTable(model);

		// ����Ʈ�� ��ȯ���� ��ü �𵨷� �߰�
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
				int result = JOptionPane.showConfirmDialog(null, "���α׷��� �����մϴ�. ����Ͻðڽ��ϱ�?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					// ����ڰ� ���� ���� ���̾�α� â�� ���� ���
				} else if (result == JOptionPane.YES_OPTION) {
					// ����ڰ� ���� ������ ���
					System.exit(0);
				} else {
					// ����ڰ� �ƴϿ��� ������ ���
				}
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Users\\LG\\Downloads\\free-icon-logout-992680.png"));
		btnExit.setBounds(735, 404, 27, 23);
		frame.getContentPane().add(btnExit);
	}

	class NewAddress extends JFrame {// �� ����ó ���
		private JFrame frame;
		private JTextField name_textField;
		private JTextField phoneNum_textField;
		private JTextField address_textField;
		private JTextField email_textField;

		public NewAddress() {
			initialize();
		}

		private void initialize() {
			// ������ ����
			frame = new JFrame("�� �ּҷ� ���");
			frame.setBounds(100, 100, 639, 416);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_NewAddress = new JLabel("==========[�� �ּҷ� ���]==========");
			title_NewAddress.setBounds(120, 0, 370, 38);
			panel.add(title_NewAddress);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// �̸� ��
			JLabel label_name = new JLabel("�̸�");
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// �̸� �Է� �ؽ�Ʈ �ʵ�
			name_textField = new JTextField();
			name_textField.setBounds(172, 14, 331, 31);
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// ��ȭ��ȣ ��
			JLabel label_phoneNum = new JLabel("��ȭ��ȣ");
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// ��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�
			phoneNum_textField = new JTextField();
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// �ּ� ��
			JLabel label_address = new JLabel("�ּ�");
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// �ּ� �Է� �ؽ�Ʈ �ʵ�
			address_textField = new JTextField();
			address_textField.setColumns(10);
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// �̸��� ��
			JLabel label_email = new JLabel("�̸���");
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// �̸��� �Է� �ؽ�Ʈ �ʵ�
			email_textField = new JTextField();
			email_textField.setColumns(10);
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// ��� ��ư
			JButton button = new JButton("���");
			// Ŭ�� �̺�Ʈ�� �߻��ϸ� �̺�Ʈ ����(�̺�Ʈ ������ �ϴܿ�)
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
				// ��ư�� ������ ������ ���� �����Ӹ� �����Ͽ� ���θ޴��� ���ư����� �Ѵ�
				frame.dispose();
			}

		}

		class TryAddListener implements ActionListener {// ��� ��ư�� ������ ����ó�� ����ϴ� ������ ����
			JTextField text_name, text_number, text_address, text_email;

			TryAddListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email) {
				// �ʵ尪�� �ޱ� ���� ������ ������Ʈ�� �����´�
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� ���� �޾ƿ� ������Ʈ���� �ʵ尪�� Person�� �ʵ尪���� �־��ش�
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

				// �̸��� �Է����� �ʾҴٸ�
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ� �Է� ����Դϴ�");
				}
				if (checkName) {
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ����ó �Դϴ�");
				} else {
					// �ߺ��Ǵ� ����ó�� �ƴ϶�� ������ ���� Person�� �ʵ尪���� Person ��ü�� �����
					Person p = new Person(name, phoneNum, address, email);
					try {
						// address book�� arrayList�� �߰��Ѵ�
						// ���� arrayList�� �ƴ϶� db�� �����Ѵ�
						ad.add(p);
						showAddress();
						JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�");
						// ����� �����ٸ� ���θ޴��� ���ư� �� �ִ� Ȩ ��ư�� ���̵��� �Ѵ�
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

		// ���� ȭ���� �ؽ�Ʈ �ʵ带 �����´�
		SerchListener(JTextField serchField) {
			this.serchField = serchField;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// ����ڰ� �Է��� �̸��� �޾ƿ´�
			String name = serchField.getText();
			// Address Book�� searchName�� �ε����� ��ȯ�ϱ� ������ �� �ε����� ������ ������ ����� ������ ����
			int target_index;
			Person p;
			try {
				// �̸��� ã�Ƽ� �� �ε����� �����Ѵ�
				// target_index = ad.searchName(name);
				// p = ad.getPerson(target_index);
				// serchName�� �ٷ� p�� �����ϹǷ� ������
				p = ad.searchName(name);
				// �˻��� ����� ���� ȭ������ �����ش�
				new search(p);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "�˻������ �������� �ʽ��ϴ�");
			}

		}
	}

	class search extends JFrame {
		private JFrame frame;
		Person p;

		// ����ȭ�鿡�� �˻��� ���(Person ��ü�� �� �ε���)�� �����´�
		public search(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			// ������ ����
			frame = new JFrame("����ó �˻�");
			frame.setBounds(100, 100, 639, 416);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[�ּҷ� �˻�]==========");
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 161, 601, 63);
			frame.getContentPane().add(scrollPane);

			// search�� ���� ã�� ���
			this.p = p;

			// Person�� �ʵ尪
			String[] colName = { "�̸�", "��ȭ��ȣ", "�ּ�", "�̸���" };

			// ���̺� �� ������ ��
			Object[][] data = { { p.getName(), p.getPhoneNum(), p.getAddress(), p.getEmail() } };

			// �����͸� ���̺�� �׸���
			// �̸����� �˻��߰�, �̸��� �ߺ����� �ʰ� �����Ƿ� �����Ͱ� �߰����� �ʾƼ� ���� ������� �ʰ� �ٷ� �׷ȴ�
			JTable table = new JTable(data, colName);
			scrollPane.setViewportView(table);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 71);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// ������ư
			JButton button_modify = new JButton("����");
			button_modify.setBackground(SystemColor.controlHighlight);
			// ������: ������ư�� ������ �����ϴ� ȭ���� ����
			button_modify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Modify(p);
				}
			});
			button_modify.setBounds(0, 29, 91, 42);
			panel_1.add(button_modify);

			// ������ư
			JButton button_delete = new JButton("����");
			button_delete.setBackground(SystemColor.controlHighlight);
			// ������: ������ư�� ������ �ٷ� �������� �ʰ� ���â���� �ٽ� �ѹ� �� ����� ���� ���â�� ����
			button_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "������ �ּҷ��� �����˴ϴ�. ����Ͻðڽ��ϱ�?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// ����ڰ� ���� ���� ���̾�α� â�� ���� ���
					} else if (result == JOptionPane.YES_OPTION) {
						// ����ڰ� ���� ������ ���
						try {
							ad.delete(p);
							showAddress();
							frame.dispose();
						} catch (Exception e1) {
							e1.getMessage();
						}
					} else {
						// ����ڰ� �ƴϿ��� ������ ���
					}
				}
			});
			button_delete.setBounds(510, 29, 91, 42);
			panel_1.add(button_delete);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 320, 601, 49);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// Ȯ�ι�ư: ����ȭ��(����ȭ��)�� �����Ѵ�
			JButton button_home = new JButton("Ȯ��");
			button_home.setBackground(SystemColor.controlHighlight);
			button_home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ���� ȭ�鸸 ����
					frame.dispose();
				}
			});
			button_home.setBounds(510, 0, 91, 42);
			panel_2.add(button_home);

			frame.setVisible(true);
		}
	}

	class Modify extends JFrame { // ����ȭ��

		private JTextField name_textField;
		private JTextField phoneNum_textField;
		private JTextField address_textField;
		private JTextField email_textField;
		Person p;
		String name_before; // ������ �̸��� Ȯ���ϱ� ���� ���(�ߺ��˻翡 �ɸ��� �ʵ���)

		private JFrame frame;

		// Address Book�� modify�Լ��� Person��ü�� �ε����� �� �� �޾Ƽ� search�������� ã�Ƴ��� ��ü�� �ε����� �޾ƿ´�
		public Modify(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			this.p = p;
			name_before = p.getName();
			// ������ ����
			frame = new JFrame("�ּҷ� ����");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[�ּҷ� ����]==========");
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// �̸� ��
			JLabel label_name = new JLabel("�̸�");
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// �̸� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �̸��� �־� ���Ҵ�
			name_textField = new JTextField(p.getName());
			name_textField.setBounds(172, 14, 331, 31);
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// ��ȭ��ȣ ��
			JLabel label_phoneNum = new JLabel("��ȭ��ȣ");
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// ��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� ��ȭ��ȣ�� �־� ���Ҵ�
			phoneNum_textField = new JTextField(p.getPhoneNum());
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// �ּ� ��
			JLabel label_address = new JLabel("�ּ�");
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// �ּ� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �ּҸ� �־� ���Ҵ�
			address_textField = new JTextField(p.getAddress());
			address_textField.setColumns(10);
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// �̸��� ��
			JLabel label_email = new JLabel("�̸���");
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// �̸��� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �̸����� �־� ���Ҵ�
			email_textField = new JTextField(p.getEmail());
			email_textField.setColumns(10);
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// ���� ��ư
			JButton button_modify = new JButton("����");
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
				// Ŭ�� �̺�Ʈ �߻� �� ������ ���������� â�� �����Ѵ�.
				frame.dispose();
			}

		}

		class ModifyButtonListener implements ActionListener {
			JTextField text_name, text_number, text_address, text_email;

			ModifyButtonListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email) {
				// �ʵ尪�� �ޱ� ���� ������ ������Ʈ�� �����´�
				this.text_name = text_name;
				this.text_number = text_number;
				this.text_address = text_address;
				this.text_email = text_email;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� ���� �޾ƿ� ������Ʈ���� �ʵ尪�� Person�� �ʵ尪���� �־��ش�
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
					// ����ڰ� �̸��� �������� ���� �� �ִµ�, �Ʒ�ó�� �ߺ��˻縦 �� ������ �̹� ��ϵ� ����ó�� üũ�ȴ�
					// ���� ������ ���� �� �̸��� �����ߴٰ� ���� ���� �׼��̺�Ʈ�� �޾ƿ� �̸��� ���ؼ� ���� ���, �� �̸��� �������� �ʰ� �ٸ� �ʵ带
					// �������� ��쿡��
					// ������ �ؾ� �Ѵ�
					Person p = new Person(name, phoneNum, address, email);
					try {
						// �ش� ����ó�� �����Ѵ�
						ad.modify(p, name_before);
						JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�");
						showAddress();
						frame.dispose();
					} catch (Exception ex) {
						// System.out.println("��� ���� �ο� ���� �ʰ��Ǿ����ϴ�.");
					}
				}
				// �̸��� �Է����� �ʾҴٸ�
				else if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ� �Է� ����Դϴ�");
				} else if (checkName) {
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ����ó�Դϴ�");
				} else {
					// �ߺ��Ǵ� ����ó�� �ƴ϶�� ������ ���� Person�� �ʵ尪���� Person ��ü�� �����
					Person p = new Person(name, phoneNum, address, email);
					try {
						// �ش� ����ó�� �����Ѵ�
						ad.modify(p, name_before);
						JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�");
						showAddress();
						frame.dispose();
					} catch (Exception ex) {
						// System.out.println("��� ���� �ο� ���� �ʰ��Ǿ����ϴ�.");
					}
				}

			}

		}
	}

}
