package dictionary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements; 

public class two extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JScrollPane jsp;
	String answertext;
	JButton searchButton;
	JTextField searchbar;
	JTextPane answer;
	URL url;
	String text;
	public two(JFrame fr){
		// TODO Auto-generated constructor stub
		
		mainPanel = new JPanel(new BorderLayout());
		jsp = new JScrollPane();
		Icon a = new ImageIcon(getClass().getResource("a.png"));
		searchButton = new JButton(a);
		searchbar = new JTextField();
		answer = new JTextPane();
		searchButton.setPressedIcon(a);
		searchbar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		searchbar.setForeground(Color.LIGHT_GRAY);
		mainPanel.add(searchbar,BorderLayout.NORTH);
		mainPanel.add(searchButton,BorderLayout.WEST);
		mainPanel.add(answer,BorderLayout.CENTER);
		jsp.setViewportView(mainPanel);
		fr.setContentPane(jsp);	
		answer.setEditable(false);
	
		searchbar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent searchb) {
				// TODO Auto-generated method stub
				try{
				doitnow();
				}
				catch(MalformedURLException ex){
					answer.setText("not found");
				}
				catch(IOException ex1){
					answer.setText("not found");
					}
				catch(Exception exep){
					answer.setText("not found");
				}
				}
		});
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)  {
			try{
				doitnow();
			}
			catch(MalformedURLException ex){
				
				answer.setText("not found");
				}
			catch(IOException ex1){
				answer.setText("not found");
				}
			catch(Exception exep){
				answer.setText("not found");
				}
			}
			}
		);}
		public void doitnow() throws Exception{
			String searchbartext = searchbar.getText();
			Document doc = Jsoup.connect("http://www.merriam-webster.com/dictionary/"+searchbartext).get();
			Elements titles = doc.select(".ld_on_collegiate");
		//	Elements titles1 = doc.select(".snum");
			StringBuilder all = new StringBuilder();
			for(Element ele : titles){	
	
				all.append(ele.text());
				all.append("\n");
			}
			/*if(all.length()<5){
			for(Element ele : titles1){	
				all.append(ele.text());
				all.append("\n");
			}
			}
			*/char[] all1 = new char[all.length()];
			all.getChars(0,all.length(),all1,0);
			StringBuilder builder = new StringBuilder();
			for(Character value : all1){
				builder.append(value);
				if(builder.length()%35 == 0)
					if(value!= ' ')
					builder.append("-\n");
					else
						builder.append("\n");
			}
			answertext = builder.toString();
			//System.out.println(answertext);
			answer.setText(answertext);
				//System.out.println("html: "+ele.html());
			/*	Elements links = doc.select("a[href]");
				for(Element ele1 : links){
					System.out.println("link : "+ele1.attr("abs.href"));
				}
			*/
			}
}
		
		
					
			
			/*url = new URL("http://www.merriam-webster.com/dictionary/whale");
			 BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		        String str = new String();
		       ArrayList<Char> all = new ArrayList<Char>();
		        while ((in.read !=null) {
		        	if(in.readLine().isEmpty()){
		        		
		        	}
		        	else{
		        	str = in.readLine().toString();
		        	}
		        	}
		        in.close();
	//	String html = "<p>An <a href='https://www.google.co.in/intl/en/ads/?fg=1'><b>example</b></a> link.</p>";
			Document doc = Jsoup.parse(str);
			text = doc.body().text(); // "An example link"
			System.out.println(text);
	*/	
		
		

