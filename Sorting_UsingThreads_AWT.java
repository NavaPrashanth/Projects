import java.awt.*;
import java.awt.event.*;

public class Sorting_UsingThreads_AWT {
	private Frame f;
	private TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	private TextField tfThread1i1,tfThread1i2,tfThread1i3,tfThread1i4,tfThread1i5;
	private TextField tfThread1o1,tfThread1o2,tfThread1o3,tfThread1o4,tfThread1o5;
	private TextField tfThread2i1,tfThread2i2,tfThread2i3,tfThread2i4,tfThread2i5;
	private TextField tfThread2o1,tfThread2o2,tfThread2o3,tfThread2o4,tfThread2o5;
	private TextField tfThread3i1,tfThread3i2,tfThread3i3,tfThread3i4,tfThread3i5;
	private TextField tfThread3i6,tfThread3i7,tfThread3i8,tfThread3i9,tfThread3i10;
	private TextField tfThread3o1,tfThread3o2,tfThread3o3,tfThread3o4,tfThread3o5;
	private TextField tfThread3o6,tfThread3o7,tfThread3o8,tfThread3o9,tfThread3o10;
	private TextField tfo1,tfo2,tfo3,tfo4,tfo5,tfo6,tfo7,tfo8,tfo9,tfo10;
	private Button btnSubmit,btnExit;
	private Label lblInput,lblThreadi1,lblThreado1,lblThreadi2,lblThreado2,lblThreadi3,lblThreado3,lblOutput;
	private Panel pnlInput,pnlThread1,pnlThread2,pnlThread3,pnlOutput;

	static int unsorted[];
	static int sorted[];
	
	public Sorting_UsingThreads_AWT() {
		unsorted = new int[10];
		sorted = new int[10];
		
		initializeComponents();
		addComponentsToFrame();
		registerListeners();
		
		f.setLayout(new GridLayout(5,1,80,10));
		f.setTitle("Multi Threaded Sorting");
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		f = new Frame();
		
		tf1 = new TextField(4);
		tf2 = new TextField(4);
		tf3 = new TextField(4);
		tf4 = new TextField(4);
		tf5 = new TextField(4);
		tf6 = new TextField(4);
		tf7 = new TextField(4);
		tf8 = new TextField(4);
		tf9 = new TextField(4);
		tf10 = new TextField(4);
		
		tfThread1i1 = new TextField(4);
		tfThread1i2 = new TextField(4);
		tfThread1i3 = new TextField(4);
		tfThread1i4 = new TextField(4);
		tfThread1i5 = new TextField(4);
		tfThread1o1 = new TextField(4);
		tfThread1o2 = new TextField(4);
		tfThread1o3 = new TextField(4);
		tfThread1o4 = new TextField(4);
		tfThread1o5 = new TextField(4);
		
		tfThread2i1 = new TextField(4);
		tfThread2i2 = new TextField(4);
		tfThread2i3 = new TextField(4);
		tfThread2i4 = new TextField(4);
		tfThread2i5 = new TextField(4);
		tfThread2o1 = new TextField(4);
		tfThread2o2 = new TextField(4);
		tfThread2o3 = new TextField(4);
		tfThread2o4 = new TextField(4);
		tfThread2o5 = new TextField(4);

		
		tfThread3i1 = new TextField(4);
		tfThread3i2 = new TextField(4);
		tfThread3i3 = new TextField(4);
		tfThread3i4 = new TextField(4);
		tfThread3i5 = new TextField(4);
		tfThread3i6 = new TextField(4);
		tfThread3i7 = new TextField(4);
		tfThread3i8 = new TextField(4);
		tfThread3i9 = new TextField(4);
		tfThread3i10 = new TextField(4);
		tfThread3o1 = new TextField(4);
		tfThread3o2 = new TextField(4);
		tfThread3o3 = new TextField(4);
		tfThread3o4 = new TextField(4);
		tfThread3o5 = new TextField(4);
		tfThread3o6 = new TextField(4);
		tfThread3o7 = new TextField(4);
		tfThread3o8 = new TextField(4);
		tfThread3o9 = new TextField(4);
		tfThread3o10 = new TextField(4);
		
		tfo1 = new TextField(4);
		tfo2 = new TextField(4);
		tfo3 = new TextField(4);
		tfo4 = new TextField(4);
		tfo5 = new TextField(4);
		tfo6 = new TextField(4);
		tfo7 = new TextField(4);
		tfo8 = new TextField(4);
		tfo9 = new TextField(4);
		tfo10 = new TextField(4);
		
		btnSubmit = new Button("submit");
		btnExit = new Button("exit");
		
		lblInput = new Label("Input > list of integers:");
		lblThreadi1 = new Label("Sorting Thread-1> Input->");
		lblThreado1 = new Label("...Output->");
		lblThreadi2 = new Label("Sorting Thread-2> Input->");
		lblThreado2 = new Label("...Output->");
		lblThreadi3 = new Label("Merge Thread> Input->");
		lblThreado3 = new Label("...Output->");
		lblOutput = new Label("Output > Sorted list");
		
		pnlInput = new Panel();
		pnlThread1 = new Panel();
		pnlThread2 = new Panel();
		pnlThread3 = new Panel();
		pnlOutput = new Panel();
	}
	
	public void addComponentsToFrame() {
		pnlInput.add(lblInput);
		pnlInput.add(tf1);
		pnlInput.add(tf2);
		pnlInput.add(tf3);
		pnlInput.add(tf4);
		pnlInput.add(tf5);
		pnlInput.add(tf6);
		pnlInput.add(tf7);
		pnlInput.add(tf8);
		pnlInput.add(tf9);
		pnlInput.add(tf10);
		pnlInput.add(btnSubmit);
		
		pnlThread1.add(lblThreadi1);
		pnlThread1.add(tfThread1i1);
		pnlThread1.add(tfThread1i2);
		pnlThread1.add(tfThread1i3);
		pnlThread1.add(tfThread1i4);
		pnlThread1.add(tfThread1i5);
		pnlThread1.add(lblThreado1);
		pnlThread1.add(tfThread1o1);
		pnlThread1.add(tfThread1o2);
		pnlThread1.add(tfThread1o3);
		pnlThread1.add(tfThread1o4);
		pnlThread1.add(tfThread1o5);
		
		pnlThread2.add(lblThreadi2);
		pnlThread2.add(tfThread2i1);
		pnlThread2.add(tfThread2i2);
		pnlThread2.add(tfThread2i3);
		pnlThread2.add(tfThread2i4);
		pnlThread2.add(tfThread2i5);
		pnlThread2.add(lblThreado2);
		pnlThread2.add(tfThread2o1);
		pnlThread2.add(tfThread2o2);
		pnlThread2.add(tfThread2o3);
		pnlThread2.add(tfThread2o4);
		pnlThread2.add(tfThread2o5);
		
		pnlThread3.add(lblThreadi3);
		pnlThread3.add(tfThread3i1);
		pnlThread3.add(tfThread3i2);
		pnlThread3.add(tfThread3i3);
		pnlThread3.add(tfThread3i4);
		pnlThread3.add(tfThread3i5);
		pnlThread3.add(tfThread3i6);
		pnlThread3.add(tfThread3i7);
		pnlThread3.add(tfThread3i8);
		pnlThread3.add(tfThread3i9);
		pnlThread3.add(tfThread3i10);
		pnlThread3.add(lblThreado3);
		pnlThread3.add(tfThread3o1);
		pnlThread3.add(tfThread3o2);
		pnlThread3.add(tfThread3o3);
		pnlThread3.add(tfThread3o4);
		pnlThread3.add(tfThread3o5);
		pnlThread3.add(tfThread3o6);
		pnlThread3.add(tfThread3o7);
		pnlThread3.add(tfThread3o8);
		pnlThread3.add(tfThread3o9);
		pnlThread3.add(tfThread3o10);
		
		pnlOutput.add(lblOutput);
		pnlOutput.add(tfo1);
		pnlOutput.add(tfo2);
		pnlOutput.add(tfo3);
		pnlOutput.add(tfo4);
		pnlOutput.add(tfo5);
		pnlOutput.add(tfo6);
		pnlOutput.add(tfo7);
		pnlOutput.add(tfo8);
		pnlOutput.add(tfo9);
		pnlOutput.add(tfo10);
		pnlOutput.add(btnExit);
		
		pnlInput.setLayout(new GridLayout(1,11));
		pnlThread1.setLayout(new GridLayout(1,12));
		pnlThread2.setLayout(new GridLayout(1,12));
		pnlThread3.setLayout(new GridLayout(1,22));
		pnlOutput.setLayout(new GridLayout(1,11));
		
		f.add(pnlInput);
		f.add(pnlThread1);
		f.add(pnlThread2);
		f.add(pnlThread3);
		f.add(pnlOutput);
		
	}
	
	public void registerListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unsorted[0] = Integer.parseInt(tf1.getText());
				unsorted[1] = Integer.parseInt(tf2.getText());
				unsorted[2] = Integer.parseInt(tf3.getText());
				unsorted[3] = Integer.parseInt(tf4.getText());
				unsorted[4] = Integer.parseInt(tf5.getText());
				unsorted[5] = Integer.parseInt(tf6.getText());
				unsorted[6] = Integer.parseInt(tf7.getText());
				unsorted[7] = Integer.parseInt(tf8.getText());
				unsorted[8] = Integer.parseInt(tf9.getText());
				unsorted[9] = Integer.parseInt(tf10.getText());
				
				sort();
			}
		});
	}
	
	public void sort() {
		Thread t1 = new Thread() {
			public void run() {
				int i,j,t;
				int a[] = new int[5];
				
				tfThread1i1.setText(unsorted[0]+"");
				tfThread1i2.setText(unsorted[1]+"");
				tfThread1i3.setText(unsorted[2]+"");
				tfThread1i4.setText(unsorted[3]+"");
				tfThread1i5.setText(unsorted[4]+"");
				
				for(i=0;i<5;i++)
					a[i] = unsorted[i];
				System.out.println("In thread1");
				for(i=0;i<4;i++) {
					for(j=0;j<4-i;j++) {
						if(a[j]>a[j+1]) {
							t = a[j];
							a[j] = a[j+1];
							a[j+1] = t;
						}
					}
				}
				for(i=0;i<5;i++) {
					unsorted[i] = a[i];
					System.out.print(unsorted[i]+" ");
				}
				System.out.println();
				
				tfThread1o1.setText(unsorted[0]+"");
				tfThread1o2.setText(unsorted[1]+"");
				tfThread1o3.setText(unsorted[2]+"");
				tfThread1o4.setText(unsorted[3]+"");
				tfThread1o5.setText(unsorted[4]+"");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				int i,j,t;
				int a[] = new int[5];
				
				tfThread2i1.setText(unsorted[5]+"");
				tfThread2i2.setText(unsorted[6]+"");
				tfThread2i3.setText(unsorted[7]+"");
				tfThread2i4.setText(unsorted[8]+"");
				tfThread2i5.setText(unsorted[9]+"");
				
				for(i=5;i<10;i++)
					a[i-5] = unsorted[i];
				System.out.println("In thread2");
				for(i=0;i<4;i++) {
					for(j=0;j<4-i;j++) {
						if(a[j]>a[j+1]) {
							t = a[j];
							a[j] = a[j+1];
							a[j+1] = t;
						}
					}
				}
				for(i=5;i<10;i++) {
					unsorted[i] = a[i-5];
					System.out.print(unsorted[i]+" ");
				}
				System.out.println();
				
				tfThread2o1.setText(unsorted[5]+"");
				tfThread2o2.setText(unsorted[6]+"");
				tfThread2o3.setText(unsorted[7]+"");
				tfThread2o4.setText(unsorted[8]+"");
				tfThread2o5.setText(unsorted[9]+"");
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				int i1=0,i2=5,j=0;
				System.out.println("In thread3");
				
				tfThread3i1.setText(unsorted[0]+"");
				tfThread3i2.setText(unsorted[1]+"");
				tfThread3i3.setText(unsorted[2]+"");
				tfThread3i4.setText(unsorted[3]+"");
				tfThread3i5.setText(unsorted[4]+"");
				tfThread3i6.setText(unsorted[5]+"");
				tfThread3i7.setText(unsorted[6]+"");
				tfThread3i8.setText(unsorted[7]+"");
				tfThread3i9.setText(unsorted[8]+"");
				tfThread3i10.setText(unsorted[9]+"");
				
				
				while(i1<=4 && i2 <=9) {
					if(unsorted[i1]<unsorted[i2]) 
						sorted[j++] = unsorted[i1++];
					else
						sorted[j++] = unsorted[i2++];
				}
				while(i1<=4)
					sorted[j++] = unsorted[i1++];
				while(i2<=9)
					sorted[j++] = unsorted[i2++];
				
				tfThread3o1.setText(sorted[0]+"");
				tfThread3o2.setText(sorted[1]+"");
				tfThread3o3.setText(sorted[2]+"");
				tfThread3o4.setText(sorted[3]+"");
				tfThread3o5.setText(sorted[4]+"");
				tfThread3o6.setText(sorted[5]+"");
				tfThread3o7.setText(sorted[6]+"");
				tfThread3o8.setText(sorted[7]+"");
				tfThread3o9.setText(sorted[8]+"");
				tfThread3o10.setText(sorted[9]+"");
			}
		};
		
		try {
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		display();
		}catch(Exception e) {
			System.out.println("excpetion!!");
		}

	}
	
	public void display() {
		tfo1.setText(sorted[0]+"");
		tfo2.setText(sorted[1]+"");
		tfo3.setText(sorted[2]+"");
		tfo4.setText(sorted[3]+"");
		tfo5.setText(sorted[4]+"");
		tfo6.setText(sorted[5]+"");
		tfo7.setText(sorted[6]+"");
		tfo8.setText(sorted[7]+"");
		tfo9.setText(sorted[8]+"");
		tfo10.setText(sorted[9]+"");
		
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(sorted[i]+" ");
	}
	public static void main(String [] args) {
		new Sorting_UsingThreads_AWT();
	}
}
