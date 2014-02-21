package bowling.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bowling.calculation.FrameCalculator;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DialogPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField EnterGame;
	private JTable GameTable;
	private JScrollPane jScrollPane1;
	private JButton SubmitButton;
	private int totalRows = 0;
	private DefaultTableModel GameTableModel;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new DialogPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public DialogPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 330));
			this.setLayout(null);
			{
				EnterGame = new JTextField();
				this.add(EnterGame);
				EnterGame.setText("Enter Game String");
				EnterGame.setPreferredSize(new java.awt.Dimension(600, 23));
				EnterGame.setBounds(50, 5, 600, 23);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(50, 55, 604, 221);
				{
					TableColumn tc = new TableColumn(0, 200);
					tc.setResizable(false);
					
					GameTableModel = 
						new DefaultTableModel(
								new String[][] { },
								new String[] { "Game #", "Entered String", "Score" });
					GameTable = new JTable(){
					      /**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int rowIndex, int colIndex) {
					          return false;   //Disallow the editing of any cell
					        }
					      };
					jScrollPane1.setViewportView(GameTable);
					GameTable.setModel(GameTableModel);
					GameTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					GameTable.setBounds(50, 55, 604, 81);
					GameTable.getColumnModel().getColumn(0).setResizable(false);
					GameTable.getColumnModel().getColumn(0).setPreferredWidth(100);
					GameTable.getColumnModel().getColumn(1).setResizable(false);
					GameTable.getColumnModel().getColumn(1).setPreferredWidth(350);
					GameTable.getColumnModel().getColumn(2).setResizable(false);
					GameTable.getColumnModel().getColumn(2).setPreferredWidth(150);
				
				}
			}
			{
				SubmitButton = new JButton();
				this.add(getSubmitButton());
				SubmitButton.setText("Submit");
				SubmitButton.setBounds(308, 296, 65, 23);
				SubmitButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						SubmitButtonMouseClicked(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JTextField getEnterGame() {
		return EnterGame;
	}
	
	public JTable getGameTable() {
		return GameTable;
	}
	
	public JButton getSubmitButton() {
		return SubmitButton;
	}
	
	private void SubmitButtonMouseClicked(MouseEvent evt) {
		String inputString = EnterGame.getText();
		FrameCalculator frameCalculator = new FrameCalculator(inputString);
		boolean validInput = frameCalculator.getAllValid();
		
		if (validInput){
			EnterGame.setText("");
			totalRows = GameTableModel.getRowCount();
			GameTableModel.insertRow(totalRows, new Object[]{"Game #"+(totalRows+1),inputString,frameCalculator.getTotal()});
		}else{
			final JPanel panel = new JPanel(); 
			JOptionPane.showMessageDialog(panel, frameCalculator.getErroMessage(), "Error",
				        JOptionPane.ERROR_MESSAGE);
		}
	
	}

}
