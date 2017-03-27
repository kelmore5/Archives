package kelmore5.java.chem.catlab;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * <pre class="doc_header">
 * This class was for a project for a chemistry class. The project was about genes, breeding, and that sort of
 * thing. The class takes input for different type of cats and randomly generates offspring based on
 * predefined conditions.
 * </pre>
 *
 * @author kelmore5
 * @custom.date Spring 2012
 */
class CatLab extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private CrossPanel panel;		//The panel for the main display
	//Blue egg shell (blue or not)
	//Creeper Legs (lethal allele) (have or do not have creeper legs)

	/**
	 * Instantiates a new Cat lab program
	 */
	private CatLab() {
		createMenus();				//Make the menus
		panel = new CrossPanel();	//Create the main display
		this.add(panel);			//Add display to the JFrame
	}

	/**
	 * Creates the menu bar for the program
	 */
	private void createMenus() {
		//Create menubar
		JMenuBar menuBar = new JMenuBar();

		//Create file menu "File" and options for exiting the program ("Quit")
		JMenu fileMenu = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(e -> System.exit(0));
		fileMenu.add(quit);

		//Create the file menu for using the program
		//E.g. Add new chicken, set a chicken as a parent, mate two chickens
		JMenu chickenMenu = new JMenu("Chicken");
		JMenuItem addChicken = new JMenuItem("Add Chicken...");
		addChicken.addActionListener(e -> panel.createChicken());
		chickenMenu.add(addChicken);
		chickenMenu.addSeparator();

		JMenuItem setParent = new JMenuItem("Set Parent");
		setParent.addActionListener(e -> panel.setParents());
		chickenMenu.add(setParent);
		
		JMenuItem mateChickens = new JMenuItem("Mate");
		mateChickens.addActionListener(e -> {
            String numKids = JOptionPane.showInputDialog(null, "How big of a litter do you want?", "Litter Size", JOptionPane.OK_CANCEL_OPTION);
            int kids;
            try {
                kids = Integer.parseInt(numKids);
            }
            catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "That was not a number.", "Something went wrong!", JOptionPane.OK_OPTION);
                return;
            }
            panel.mateChickens(kids);
        });
		chickenMenu.add(mateChickens);

		//Add file menu items to menu bar
		//And then add menu bar to the JFrame
		menuBar.add(fileMenu);
		menuBar.add(chickenMenu);
		this.setJMenuBar(menuBar);
	}
	
	public void run() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Set program to close on exit
		this.setTitle("Chicken Lab");							//Set title
		this.setSize(500,500);								//Set size
		this.setVisible(true);									//Set visiblity to true
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		CatLab mf = new CatLab();
		javax.swing.SwingUtilities.invokeLater(mf);
	}
}
