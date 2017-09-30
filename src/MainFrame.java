import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;


public class MainFrame extends JFrame {
    private JButton gol=new JButton("Left");
    private JButton gor=new JButton("Right");
    private JButton fire=new JButton("Shoot");
    private JButton ST=new JButton("START");
    private int count=0,ran1,ran2,ran3,ran4;
    private JLabel score=new JLabel("score:"+count);
    private JLabel gun=new JLabel("\uD83D\uDD2B");
    private JLabel bul=new JLabel("╽");
    private JLabel tar=new JLabel("(❍ᴥ❍ʋ)");
    private JLabel tar2=new JLabel("(ΦωΦ)");
    private Timer t1;
    public Timer t2;
    public MainFrame(){
        init();
    }
    private void init(){
        Random ran=new Random();
        this.setBounds(100,100,500,500);
        this.setLayout(null);
        gol.setBounds(100,400,100,50);
        score.setBounds(400,50,100,50);
        gor.setBounds(300,400,100,50);
        fire.setBounds(200,400,100,50);
        tar.setBounds(200,50,100,50);
        tar2.setBounds(200,50,100,50);
        gun.setBounds(200,300,100,50);
        bul.setBounds(600,600,100,50);
        ST.setBounds(200,300,100,50);
        this.add(gol);  this.add(gun);  this.add(gor);  this.add(fire);  add(bul);  add(tar);  add(tar2); add(ST);add(score);
        t2=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tar.setLocation(ran.nextInt(300)+0,ran.nextInt(50)+20);
                tar2.setLocation(ran.nextInt(300)+0,ran.nextInt(50)+10);

            }
        });
        t1=new Timer(15,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bul.setLocation(bul.getX()-0,bul.getY()-10);
                if(tar.getX()+50>bul.getX()){
                    count++; score.setText("score:"+count);
                }else if(tar2.getX()+50>bul.getX()){
                    count++; score.setText("score:"+count);
                }

            }
        });
        gol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gun.setLocation(gun.getX()-20,300);
            }
        });
        gor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gun.setLocation(gun.getX()+20,300);
            }
        });
        fire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bul.setLocation(  gun.getX()+0,gun.getY()-10);
                t1.start();


            }
        });
        ST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.start();
                ST.setVisible(false);
            }
        });

    }

}