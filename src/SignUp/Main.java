package SignUp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class User {
	private String id;
	private String name;
	private String pw;
	
	public User(String id, String name, String pw) {
		this.id = id;
		this.name = name;
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nPW : " + pw + "\n";
	}
}

public class Main {
    TextField idField;
    TextField nameField;
    TextField pwField;
    ArrayList<User> userList = new ArrayList<>();
    
    TextArea ta;

    public Main() {
        Frame f = new Frame("회원 가입");
        Button b1 = new Button("가입");
        Button b2 = new Button("전체 계정 조회");
        ta = new TextArea();

        // 전체 입력 필드를 포함할 Panel
        Panel inputPanel = new Panel();

        // ID 입력 부분
        Panel idPanel = new Panel();
        Label idLabel = new Label("ID:");
        idField = new TextField(20);
        idPanel.add(idLabel);
        idPanel.add(idField);

        // Name 입력 부분
        Panel namePanel = new Panel();
        Label nameLabel = new Label("Name:");
        nameField = new TextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Password 입력 부분
        Panel pwPanel = new Panel();
        Label pwLabel = new Label("Password:");
        pwField = new TextField(20);
        pwPanel.add(pwLabel);
        pwPanel.add(pwField);

        // 각 입력 패널을 메인 입력 패널에 추가
        inputPanel.add(idPanel);
        inputPanel.add(namePanel);
        inputPanel.add(pwPanel);

        // 버튼 패널
        Panel buttonPanel = new Panel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        // Frame 설정
        f.add(ta, BorderLayout.NORTH); // 위에 전체 고객 조회
        f.add(inputPanel, BorderLayout.CENTER); // 중간에 가입 Form
        f.add(buttonPanel, BorderLayout.SOUTH);  // 아래쪽에 버튼
        
        // "가입" 버튼 이벤트
        b1.addActionListener( e -> {
        	String id = idField.getText();
        	String name = nameField.getText();
        	String pw = pwField.getText();
        	
            if (id.isEmpty() || name.isEmpty() || pw.isEmpty()) {
            	ta.setText("");
                ta.append("모든 정보를 입력해주세요.");
                return;
            }
        	
        	User u = new User(id, name, pw);
        	userList.add(u);
        	
        	idField.setText("");
        	nameField.setText("");
        	pwField.setText("");
        });
        
        // "전체 계정 조회" 버튼 이벤트
        b2.addActionListener(e -> {
        	ta.setText("");
            for (User user : userList) {
                ta.append(user.toString()+"\n");
            }
        });

        // "창 닫기" 이벤트
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setSize(400, 400);
        f.setBackground(Color.LIGHT_GRAY);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
