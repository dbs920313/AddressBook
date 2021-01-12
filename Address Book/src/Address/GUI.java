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

	// address book�� �޼ҵ�� �ʵ� ����� ���� �Ķ���ͷ� �޾ƿ´�
	/*
	public GUI() throws Exception{
		initialize();
		ad = new AddressBook();
	}*/

	/*
	public static void main(String[] args) {
		// ���� �ʿ� ����
		// ObjectInputStream in = null;
		// ObjectOutputStream out = null;

		// AddressBook ad = new AddressBook();
		/*
		 * try { //����� ���� �о���� in = new ObjectInputStream(new
		 * FileInputStream("addressbook.dat")); ad = new AddressBook(100, in);
		 * in.close(); } catch (FileNotFoundException fnfe) { try { //ó�� �����Ѵٸ� ���� �ּҷ�
		 * ����� ad = new AddressBook(100); } catch (Exception e) { } } catch (Exception
		 * ex) { }
		 */
	/*
		// �о�� address book�� �Ű������� �Ѱ��ش�
		try {	
			GUI gui = new GUI();
		} catch (Exception e) {
			e.getMessage();
		}
	}*/
/*
	private void initialize() { // ���� �޴� ����
		// ������ ����
		JFrame frame = new JFrame("�ּҷ� ���α׷�");
		frame.setFont(new Font("THE�ܰ��μ���", Font.BOLD, 15));
		frame.setBounds(100, 100, 684, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 646, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// �̸����� �˻��ϱ� ���� �ؽ�Ʈ ����
		JTextField serchField = new JTextField();
		serchField.setHorizontalAlignment(SwingConstants.CENTER);
		serchField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
		serchField.setText("�̸����� �˻�");
		serchField.setBounds(12, 10, 527, 42);
		panel.add(serchField);
		serchField.setColumns(10);

		// �˻� ��ư
		// �ؽ�Ʈ�� "�˻�" �� �ִ� �� ���� ������ �̹����� ��Ÿ���°� �� ���� �� �� �� ���Ƽ� �̹��� �������� �־���
		JButton serchButton = new JButton();
		serchButton.setIcon(new ImageIcon(
				"C:\\\uC11C\uC6B8\uC5EC\uB300\\2020 2\uD559\uAE30\\javaWork\\Address Book\\magnify glass.png"));
		serchButton.setBackground(SystemColor.controlHighlight);
		// ������: Ŭ���̺�Ʈ�� �߻��ϸ� ���� �ؽ�Ʈ �ʵ尪�� �̸����� �����Ͽ� �˻��ϴ� â�� ����
		serchButton.addActionListener(new SerchListener(serchField));
		serchButton.setBounds(543, 10, 91, 42);
		panel.add(serchButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 82, 646, 269);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		// �޴� 1: �� �ּҷ� ���
		JButton add_Button = new JButton("�� �ּҷ� ���");
		// ������: Ŭ�� �̺�Ʈ�� �߻��ϸ� �ּҷ� ��� â(�� â)�� ����
		add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewAddress();
			}
		});
		add_Button.setBackground(SystemColor.controlHighlight);
		add_Button.setFont(new Font("THE�ܰ��μ���", Font.BOLD, 30));
		add_Button.setBounds(12, 30, 293, 77);
		panel_1.add(add_Button);

		// �޴� 2: ��ü �ּҷ� ��ȸ
		JButton view_Button = new JButton("��ü �ּҷ� ��ȸ");
		view_Button.setBackground(SystemColor.controlHighlight);
		view_Button.setFont(new Font("THE�ܰ��μ���", Font.BOLD, 30));
		// ������: Ŭ�� �̺�Ʈ�� �߻��ϸ� ��ü �ּҷ� ��ȸâ(�� â)�� ����
		view_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new All();
			}
		});
		view_Button.setBounds(341, 30, 293, 77);
		panel_1.add(view_Button);

		/*
		 * //�޴� 3: �ּҷ� ���Ϸ� ���� JButton save_Button = new JButton("�ּҷ� ����"); //������: Ŭ���̺�Ʈ��
		 * �߻��ϸ� ����ȭ���� ���� save_Button.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent e) { new Save(); } });
		 * save_Button.setBackground(SystemColor.controlHighlight);
		 * save_Button.setFont(new Font("THE�ܰ��μ���", Font.BOLD, 30));
		 * save_Button.setBounds(12, 162, 293, 77); panel_1.add(save_Button);
		 */
/*
		// �޴� 4: ���α׷� ����
		JButton exit_Button = new JButton("���α׷� ����");
		exit_Button.setBounds(341, 162, 293, 77);
		panel_1.add(exit_Button);
		// ������: Ŭ���̺�Ʈ�� �߻��ϸ� �����ϰ� �����϶�� ��� �޽��� â�� ����
		exit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Exit();
			}
		});
		exit_Button.setBackground(SystemColor.controlHighlight);
		exit_Button.setFont(new Font("THE�ܰ��μ���", Font.BOLD, 30));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 361, 646, 88);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// ���� ���� �޴��� �ּҷ��� �˻��Ͽ� �׿� ���� �˻� ����� ���� â���� �� �� �ֵ��� ������ ���̴� => ���� �޴����� ����

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

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
				new serch(p);
			} catch (Exception e1) {
				new NameNotFound();
			}

		}
	}

	class NewAddress extends JFrame { // �� ����ó ��� â

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
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_NewAddress = new JLabel("==========[�� �ּҷ� ���]==========");
			title_NewAddress.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_NewAddress.setBounds(120, 0, 370, 38);
			panel.add(title_NewAddress);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// �̸� ��
			JLabel label_name = new JLabel("�̸�");
			label_name.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// �̸� �Է� �ؽ�Ʈ �ʵ�
			name_textField = new JTextField();
			name_textField.setBounds(172, 14, 331, 31);
			name_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// ��ȭ��ȣ ��
			JLabel label_phoneNum = new JLabel("��ȭ��ȣ");
			label_phoneNum.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// ��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�
			phoneNum_textField = new JTextField();
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// �ּ� ��
			JLabel label_address = new JLabel("�ּ�");
			label_address.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// �ּ� �Է� �ؽ�Ʈ �ʵ�
			address_textField = new JTextField();
			address_textField.setColumns(10);
			address_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// �̸��� ��
			JLabel label_email = new JLabel("�̸���");
			label_email.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// �̸��� �Է� �ؽ�Ʈ �ʵ�
			email_textField = new JTextField();
			email_textField.setColumns(10);
			email_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// ����ڰ� ��� ��ư�� ������ �� ������ �޽���1
			JLabel message_error = new JLabel("�̹� �����ϴ� ����ó �Դϴ�");
			message_error.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_error.setBounds(309, 13, 179, 37);
			panel_2.add(message_error);
			// ����ڰ� ��� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_error.setVisible(false);

			// ����ڰ� ��� ��ư�� ������ �� ������ �޽���2
			JLabel message_success = new JLabel("����ó�� ���������� ��ϵǾ����ϴ�");
			message_success.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_success.setBounds(235, 10, 251, 42);
			panel_2.add(message_success);
			// ����ڰ� ��� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_success.setVisible(false);

			// ����ڰ� ��� ��ư�� ������ �� ������ �޽���3
			JLabel message_noname = new JLabel("�̸��� �ʼ� �Է� ����Դϴ�");
			message_noname.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_noname.setBounds(235, 10, 251, 42);
			panel_2.add(message_noname);
			// ����ڰ� ��� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_noname.setVisible(false);

			// ������� ����ó ����� ���� �� ���� ��ư
			JButton home = new JButton("Ȩ");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// Ŭ�� �� ���θ޴� ȭ������ ���ư��� ���� �̺�Ʈ ������
			home.addActionListener(new ToHome());
			panel_2.add(home);
			// ����ڰ� ��� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			home.setVisible(false);

			// ��� ��ư
			JButton button = new JButton("���");
			// Ŭ�� �̺�Ʈ�� �߻��ϸ� �̺�Ʈ ����(�̺�Ʈ ������ �ϴܿ�)
			button.addActionListener(new TryAddListener(name_textField, phoneNum_textField, address_textField,
					email_textField, message_error, message_success, home, message_noname));
			button.setBackground(SystemColor.controlHighlight);
			button.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
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
			JLabel message_error, message_success, message_noname;
			JTextField text_name, text_number, text_address, text_email;
			JButton home;

			TryAddListener(JTextField text_name, JTextField text_number, JTextField text_address, JTextField text_email,
					JLabel message_error, JLabel message_success, JButton home, JLabel message_noname) {
				// �ʵ尪�� �ޱ� ���� ������ ������Ʈ�� �����´�
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
					// �̸��� �ʼ� �Է¿�Ҷ�� �޽����� ����Ѵ�.
					message_noname.setVisible(true);
					// ����ڰ� �Ǽ��� ��� ��ư�� ������ �ٸ� �޽����� ������ �ʾƾ� �ϹǷ� �Ⱥ��̵��� �����Ѵ�.
					message_success.setVisible(false);
					message_error.setVisible(false);
				}
				if (checkName) {
					// �ߺ��̶�� �ߺ� �޽����� ����Ѵ�
					message_error.setVisible(true);
					// ����ڰ� �Ǽ��� ��� ��ư�� �� �� �� ������ �Ǹ� ��� ���� �޽����� ���ļ� ��� ���� �޽����� �ٽ� �Ⱥ��̵��� �����ߴ�
					message_success.setVisible(false);
					message_noname.setVisible(false);
				} else {
					// �ߺ��Ǵ� ����ó�� �ƴ϶�� ������ ���� Person�� �ʵ尪���� Person ��ü�� �����
					Person p = new Person(name, phoneNum, address, email);
					try {
						// address book�� arrayList�� �߰��Ѵ�
						// ���� arrayList�� �ƴ϶� db�� �����Ѵ�
						ad.add(p);
						// ��� ���� �޽����� ����Ѵ�
						message_success.setVisible(true);
						// Ȥ�� ������ ����Ϸ��� �ּҷ��� �ߺ��˻縦 ������� ���ؼ� �����ؼ� �ٽ� ����ϴ� ��� �޽����� ���� �ߺ� �޽����¾Ⱥ��̵��� �����ߴ�
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// ����� �����ٸ� ���θ޴��� ���ư� �� �ִ� Ȩ ��ư�� ���̵��� �Ѵ�
						home.setVisible(true);
					} catch (Exception ex) {
						ex.getMessage();
					}
				}
			}

		}
	}

	class All extends JFrame { // �ּҷ� ��ü ��ȸ â

		JFrame frame;

		public All() {
			initialize();
		}

		private void initialize() {
			// ������ ����
			frame = new JFrame("��ü �ּҷ� ��ȸ");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 40);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_view = new JLabel("==========[��ü �ּҷ� ��ȸ]==========");
			title_view.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_view.setBounds(114, 0, 410, 40);
			panel.add(title_view);

			// Person�� �ʵ尪
			String[] colName = { "�̸�", "��ȭ��ȣ", "�ּ�", "�̸���" };

			// ����ó�� �߰�, ������ ��� �ش� ���� �߰� �����ؾ��ϱ� ������ ���� �����ߴ�
			DefaultTableModel model = new DefaultTableModel(colName, 0);
			JTable table = new JTable(model);
			/*
			 * //������ ����� �ּҷ��� �ִٸ� ����� ����ó ������ŭ �ݺ��� ���� int c = ad.getCount(); //Person ��ü��
			 * �����͸� ���� ���� ���� Object[] data; Person p; for(int i = 0; i < c; i++) { p =
			 * ad.getPerson(i); data = new Object[] {p.getName(), p.getPhoneNum(),
			 * p.getAddress(), p.getEmail()}; model.addRow(data); }
			 */
			// ����Ʈ�� ��ȯ���� ��ü �𵨷� �߰�
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
			table.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(12, 62, 601, 256);
			frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

			frame.getContentPane().add(scrollPane);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 326, 601, 53);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// ��ü �ּҷ� Ȯ���� �����ٸ� ���� ���� �������� ������ ��ư
			JButton home = new JButton("Ȩ");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// Ŭ�� �̺�Ʈ: ���θ޴��� ���ư���
			home.addActionListener(new ToHome());
			panel_1.add(home);

			frame.setVisible(true);

		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ŭ�� �̺�Ʈ �߻� �� ������ ���������� â�� �����Ѵ�.
				frame.dispose();
			}

		}
	}

	class serch extends JFrame { // �˻�ȭ��

		private JFrame frame;
		Person p;

		// ����ȭ�鿡�� �˻��� ���(Person ��ü�� �� �ε���)�� �����´�
		public serch(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
			// ������ ����
			frame = new JFrame("����ó �˻�");
			frame.setBounds(100, 100, 639, 416);
			// ���� â���� X�� �����ٰ� ���α׷��� ����Ǹ� �ȵǱ� ������ �Ʒ��� �ּ�ó���ߴ�
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[�ּҷ� �˻�]==========");
			title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
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
			table.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			scrollPane.setViewportView(table);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 71);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// ������ư
			JButton button_modify = new JButton("����");
			button_modify.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
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
			button_delete.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_delete.setBackground(SystemColor.controlHighlight);
			// ������: ������ư�� ������ �ٷ� �������� �ʰ� ���â���� �ٽ� �ѹ� �� ����� ���� ���â�� ����
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

			// Ȯ�ι�ư: ����ȭ��(����ȭ��)�� �����Ѵ�
			JButton button_home = new JButton("Ȯ��");
			button_home.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
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
			title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 244);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			// �̸� ��
			JLabel label_name = new JLabel("�̸�");
			label_name.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_name.setBounds(77, 14, 73, 31);
			panel_1.add(label_name);

			// �̸� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �̸��� �־� ���Ҵ�
			name_textField = new JTextField(p.getName());
			name_textField.setBounds(172, 14, 331, 31);
			name_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			panel_1.add(name_textField);
			name_textField.setColumns(10);

			// ��ȭ��ȣ ��
			JLabel label_phoneNum = new JLabel("��ȭ��ȣ");
			label_phoneNum.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_phoneNum.setBounds(77, 70, 73, 31);
			panel_1.add(label_phoneNum);

			// ��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� ��ȭ��ȣ�� �־� ���Ҵ�
			phoneNum_textField = new JTextField(p.getPhoneNum());
			phoneNum_textField.setColumns(10);
			phoneNum_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			phoneNum_textField.setBounds(172, 70, 331, 31);
			panel_1.add(phoneNum_textField);

			// �ּ� ��
			JLabel label_address = new JLabel("�ּ�");
			label_address.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_address.setBounds(77, 134, 73, 31);
			panel_1.add(label_address);

			// �ּ� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �ּҸ� �־� ���Ҵ�
			address_textField = new JTextField(p.getAddress());
			address_textField.setColumns(10);
			address_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			address_textField.setBounds(172, 134, 331, 31);
			panel_1.add(address_textField);

			// �̸��� ��
			JLabel label_email = new JLabel("�̸���");
			label_email.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			label_email.setBounds(77, 195, 73, 31);
			panel_1.add(label_email);

			// �̸��� �Է� �ؽ�Ʈ �ʵ�: ������ ����Ǿ��ִ� �̸����� �־� ���Ҵ�
			email_textField = new JTextField(p.getEmail());
			email_textField.setColumns(10);
			email_textField.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			email_textField.setBounds(172, 195, 331, 31);
			panel_1.add(email_textField);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 312, 601, 57);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			// ����ڰ� �Է��� �̸��� �ߺ��� �̸��� ��� ǥ���� �޽���
			JLabel message_error = new JLabel("�̹� �����ϴ� ����ó �Դϴ�");
			message_error.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_error.setBounds(309, 13, 179, 37);
			panel_2.add(message_error);
			// ����ڰ� ���� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_error.setVisible(false);

			// ���������� ������ ��� ǥ���� �޽���
			JLabel message_success = new JLabel("����ó�� ���������� �����Ǿ����ϴ�");
			message_success.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_success.setBounds(235, 10, 251, 42);
			panel_2.add(message_success);
			// ����ڰ� ���� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_success.setVisible(false);

			// �̸��� �Է����� ���� ��� ǥ���� �޽���
			JLabel message_noname = new JLabel("�̸��� �ʼ� �Է� ����Դϴ�");
			message_noname.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			message_noname.setBounds(235, 10, 251, 42);
			panel_2.add(message_noname);
			// ����ڰ� ���� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			message_noname.setVisible(false);

			// ������� ����ó ������ ���� �� ���� ��ư
			JButton home = new JButton("Ȩ");
			home.setBackground(SystemColor.controlHighlight);
			home.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			home.setBounds(498, 10, 91, 42);
			// Ŭ�� �� ���θ޴� ȭ������ ���ư��� ���� �̺�Ʈ ������
			home.addActionListener(new ToHome());
			panel_2.add(home);
			// ����ڰ� ��� ��ư�� ������ ������ ������̱� ������ �켱�� ������ �ʵ��� ����
			home.setVisible(false);

			// ���� ��ư
			JButton button_modify = new JButton("����");
			button_modify.setBackground(SystemColor.controlHighlight);
			button_modify.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_modify.setBounds(498, 10, 91, 42);
			panel_2.add(button_modify);
			button_modify.addActionListener(new ModifyButtonListener(name_textField, phoneNum_textField,
					address_textField, email_textField, message_error, message_success, home, message_noname));

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
			JLabel message_error, message_success, message_noname;
			JTextField text_name, text_number, text_address, text_email;
			JButton home;

			ModifyButtonListener(JTextField text_name, JTextField text_number, JTextField text_address,
					JTextField text_email, JLabel message_error, JLabel message_success, JButton home,
					JLabel message_noname) {
				// �ʵ尪�� �ޱ� ���� ������ ������Ʈ�� �����´�
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
						// ��� ���� �޽����� ����Ѵ�
						message_success.setVisible(true);
						// Ȥ�� ������ ����Ϸ��� �ּҷ��� �ߺ��˻縦 ������� ���ؼ� �����ؼ� �ٽ� ����ϴ� ���
						// �޽����� ���� �ߺ� �޽����¾Ⱥ��̵��� �����ߴ�
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// ����� �����ٸ� ���θ޴��� ���ư� �� �ִ� Ȩ ��ư�� ���̵��� �Ѵ�
						home.setVisible(true);
					} catch (Exception ex) {
						// System.out.println("��� ���� �ο� ���� �ʰ��Ǿ����ϴ�.");
					}
				}
				// �̸��� �Է����� �ʾҴٸ�
				else if (name.equals("")) {
					// �̸��� �ʼ� �Է¿�Ҷ�� �޽����� ����Ѵ�.
					message_noname.setVisible(true);
					// ����ڰ� �Ǽ��� ��� ��ư�� ������ �ٸ� �޽����� ������ �ʾƾ� �ϹǷ� �Ⱥ��̵��� �����Ѵ�.
					message_success.setVisible(false);
					message_error.setVisible(false);
				}
				else if (checkName) {
					// �ߺ��̶�� �ߺ� �޽����� ����Ѵ�
					message_error.setVisible(true);
					// ����ڰ� �Ǽ��� ��� ��ư�� �� �� �� ������ �Ǹ� ��� ���� �޽����� ���ļ� ��� ���� �޽����� �ٽ� �Ⱥ��̵��� �����ߴ�
					message_success.setVisible(false);
					message_noname.setVisible(false);
				} else {
					// �ߺ��Ǵ� ����ó�� �ƴ϶�� ������ ���� Person�� �ʵ尪���� Person ��ü�� �����
					Person p = new Person(name, phoneNum, address, email);
					try {
						// �ش� ����ó�� �����Ѵ�
						ad.modify(p, name_before);
						// ��� ���� �޽����� ����Ѵ�
						message_success.setVisible(true);
						// Ȥ�� ������ ����Ϸ��� �ּҷ��� �ߺ��˻縦 ������� ���ؼ� �����ؼ� �ٽ� ����ϴ� ��� �޽����� ���� �ߺ� �޽����¾Ⱥ��̵��� �����ߴ�
						message_error.setVisible(false);
						message_noname.setVisible(false);
						// ����� �����ٸ� ���θ޴��� ���ư� �� �ִ� Ȩ ��ư�� ���̵��� �Ѵ�
						home.setVisible(true);
					} catch (Exception ex) {
						// System.out.println("��� ���� �ο� ���� �ʰ��Ǿ����ϴ�.");
					}
				}

			}

		}
	}

	class Delete extends JFrame { // ����ڿ��� ������ �����Ұ��� �ٽ� �����

		private JFrame frame;

		// �ش� �ּҷϸ� �����ؾ� �ϱ� ������ search���� ã�� Person ��ü�� ��ü�� �ε����� �޾ƿ´�
		public Delete(Person p) {
			initialize(p);
		}

		private void initialize(Person p) {
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
			title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 311);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("������ �ּҷ��� �����˴ϴ�");
			lblNewLabel.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel.setBounds(207, 78, 180, 30);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("����Ͻðڽ��ϱ�?");
			lblNewLabel_1.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(231, 111, 127, 30);
			panel_1.add(lblNewLabel_1);

			JButton button_yes = new JButton("��");
			button_yes.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_yes.setBounds(69, 221, 91, 42);
			button_yes.setBackground(SystemColor.controlHighlight);
			panel_1.add(button_yes);
			// ������: ����ڰ� �� ��ư�� ������ �ش� �ּҷ��� �����Ѵ�
			button_yes.addActionListener(new YesButtonListener(p));

			JButton button_no = new JButton("�ƴϿ�");
			button_no.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_no.setBounds(428, 221, 91, 42);
			button_no.setBackground(SystemColor.controlHighlight);
			// ������: ���� â(����������)�� �����Ѵ�
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
	 * class Save extends JFrame{//�ּҷ� ���� ����
	 * 
	 * private JFrame frame;
	 * 
	 * public Save() { initialize(); }
	 * 
	 * private void initialize() { // ������ ���� frame = new JFrame("�ּҷ� ����");
	 * frame.setBounds(100, 100, 639, 416);
	 * //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.getContentPane().setLayout(null);
	 * 
	 * JPanel panel = new JPanel(); panel.setBounds(12, 10, 601, 38);
	 * frame.getContentPane().add(panel); panel.setLayout(null);
	 * 
	 * JLabel title_Serch = new JLabel("==========[�ּҷ� ����]==========");
	 * title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
	 * title_Serch.setBounds(120, 0, 370, 38); panel.add(title_Serch);
	 * frame.getContentPane().add(panel);
	 * 
	 * JPanel panel_1 = new JPanel(); panel_1.setBounds(12, 71, 601, 240);
	 * frame.getContentPane().add(panel_1); panel_1.setLayout(null);
	 * 
	 * JLabel lblNewLabel = new JLabel("���ݱ��� ��ϵ� ����ó�� ���Ϸ� �����մϴ�");
	 * lblNewLabel.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
	 * lblNewLabel.setBounds(150, 60, 290, 48); panel_1.add(lblNewLabel);
	 * 
	 * JLabel lblNewLabel_1 = new JLabel("����Ͻðڽ��ϱ�?"); lblNewLabel_1.setFont(new
	 * Font("THE�ܰ��μ���", Font.PLAIN, 15)); lblNewLabel_1.setBounds(229, 96, 155,
	 * 48); panel_1.add(lblNewLabel_1);
	 * 
	 * JButton button_yes = new JButton("��"); button_yes.setFont(new
	 * Font("THE�ܰ��μ���", Font.PLAIN, 15)); button_yes.setBounds(72, 190, 91, 42);
	 * button_yes.setBackground(SystemColor.controlHighlight); //������: ����ڰ� ���� ������
	 * ���Ϸ� �ּҷ��� �����Ѵ� button_yes.addActionListener(new YesButtonListener());
	 * panel_1.add(button_yes);
	 * 
	 * JButton button_no = new JButton("�ƴϿ�"); button_no.setFont(new
	 * Font("THE�ܰ��μ���", Font.PLAIN, 15)); button_no.setBounds(434, 190, 91, 42);
	 * button_no.setBackground(SystemColor.controlHighlight); //������: ����â(����������)��
	 * �����Ѵ� button_no.addActionListener(new NoButtonListener());
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
	 * ad.writeFile(out); //System.out.println("����Ǿ����ϴ�."); } catch
	 * (FileNotFoundException fnfe) { //System.out.println(fnfe.getMessage()); }
	 * catch (IOException ioe) { //System.out.println("������ �����߽��ϴ�."); } catch
	 * (Exception ex) {
	 * 
	 * } finally { // close()�̿��� out�� ����� �������� ���� try { out.close(); } catch
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
	class NameNotFound extends JFrame { // �˻����� �̸��� ã�� ������ ���

		private JFrame frame;

		public NameNotFound() {
			initialize();
		}

		private void initialize() {
			// ������ ����
			frame = new JFrame("����ó �˻�");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[�ּҷ� �˻�]==========");
			title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 71, 601, 240);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("��ϵ� �ּҷ��� �����ϴ�");
			lblNewLabel.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel.setBounds(215, 61, 155, 48);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("����ȭ������ ���ư��ϴ�");
			lblNewLabel_1.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(215, 97, 155, 48);
			panel_1.add(lblNewLabel_1);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 323, 601, 46);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			JButton button_ok = new JButton("Ȯ��");
			button_ok.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_ok.setBounds(510, 0, 91, 42);
			button_ok.setBackground(SystemColor.controlHighlight);
			// ������: Ȯ�ι�ư�� ������ ����â�� �����Ѵ�
			button_ok.addActionListener(new ToHome());
			panel_2.add(button_ok);

			frame.setVisible(true);
		}

		class ToHome implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ŭ�� �̺�Ʈ �߻� �� ������ ���������� â�� �����Ѵ�.
				frame.dispose();
			}

		}
	}

	class Exit extends JFrame { // ���α׷� ���� ��ư�� ������ ����ڰ� ������ �ߴ��� �� ���� Ȯ���� �� �ֵ��� �˷��ִ� ���â

		private JFrame frame;

		public Exit() {
			initialize();
		}

		private void initialize() {
			// ������ ����
			frame = new JFrame("���α׷� ����");
			frame.setBounds(100, 100, 639, 416);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 601, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			JLabel title_Serch = new JLabel("==========[���α׷� ����]==========");
			title_Serch.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 20));
			title_Serch.setBounds(120, 0, 370, 38);
			panel.add(title_Serch);
			frame.getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 58, 601, 311);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("���α׷��� �����մϴ�");
			lblNewLabel.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel.setBounds(226, 88, 148, 33);
			panel_1.add(lblNewLabel);

			JLabel lblNewLabel_2 = new JLabel("����Ͻðڽ��ϱ�?");
			lblNewLabel_2.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(237, 141, 124, 33);
			panel_1.add(lblNewLabel_2);

			JButton button_yes = new JButton("��");
			button_yes.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_yes.setBounds(90, 213, 91, 42);
			button_yes.addActionListener(new YesButtonListener());
			button_yes.setBackground(SystemColor.controlHighlight);
			panel_1.add(button_yes);

			JButton button_no = new JButton("�ƴϿ�");
			button_no.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 15));
			button_no.setBackground(SystemColor.controlHighlight);
			button_no.setBounds(432, 213, 91, 42);
			// ������: �ƴϿ� ��ư�� ������ ����â�� �����Ѵ�
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
