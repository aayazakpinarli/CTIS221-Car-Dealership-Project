//package MainandSystem;

//import GUI.MainFrame;

public class DealershipMain {

	public static void main(String[] args) {
		
        DealerSys.readFromFile();
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        
    }
} 