import java.util.*;
public class PageReplacementAlgorithm {
	static Scanner ip=new Scanner(System.in);
	public static void main(String[]args) {
		Random rand=new Random();
		System.out.println("Enter number of elements");
		int n,k,i=0,j=0,t,c1=0,c2=0,c3=0,count=0,b1=1,b2=1,b3=1;
		n=ip.nextInt();
		k=n;
		int[] a=new int[n];
		for(i=0;i<n;i++) {
			a[i]=rand.nextInt(10);
		}
		int[][] b=new int[3][n];
		System.out.print("Page Reference string -> ");
		for(i=0;i<n;i++) 
			System.out.print(a[i]+"  ");
		System.out.println();
		for(i=0;i<3;i++) {
			for(j=i;j>=0;j--) {
				b[j][i]=a[j];
			}
		}
		//fifo algorithm
		k=2;
		j=0;
		for(i=3;i<n;i++) {
			if(j==3) {
				j=0;
			}
			if(a[i]!=b[0][k] && a[i]!=b[1][k] && a[i]!=b[2][k]) {
				b[0][k+1]=b[0][k];
				b[1][k+1]=b[1][k];
				b[2][k+1]=b[2][k];
				b[j][k+1]=a[i];
				j++;k++;
			}
		}
		//fifo display
		System.out.println();
		System.out.println("FIFO PAGE FRAMES");
		for(i=0;i<3;i++) {
			for(j=0;j<=k;j++) {
				System.out.print(b[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Number of Page_faults for FIFO Page Replacement Algorithm is :"+(k+1));
		//LRU algorithm
		k=2;
		for(i=3;i<n;i++) {
			if(a[i]!=b[0][k] && a[i]!=b[1][k] && a[i]!=b[2][k]) {
				c1=-1;c2=-1;c3=-1;b1=1;b2=1;b3=1;
				for(t=i-1;t>=0;t--) {
					if(a[t]==b[0][k]) {
						while(b1>0) {
							c1=t;
							b1--;
						}
					}
					else if(a[t]==b[1][k]) {
						while(b2>0) {
							c2=t;
							b2--;
						}
					}
					else if(a[t]==b[2][k]) {
						while(b3>0) {
							c3=t;
							b3--;
						}
					}
					
				}
				if(c1==-1 || c2==-1 || c3==-1) {
					if(c1==-1) {
						count=0;
					}
					else if(c2==-1) {
						count=1;
					}
					else if(c3==-1) {
						count=2;
					}
				}
				else {
					if(c1<=c2) {
						if(c1<=c3) {
							count=0;
						}
						else
							count=2;
					}
					else {
						if(c2<=c3) {
							count=1;
						}
						else {
							count=2;
						}
					}
				}
				b[0][k+1]=b[0][k];
				b[1][k+1]=b[1][k];
				b[2][k+1]=b[2][k];
				b[count][k+1]=a[i];
				k++;
			}
		}
		//LRU display
		System.out.println();
		System.out.println("LRU PAGE FRAMES");
		for(i=0;i<3;i++) {
			for(j=0;j<=k;j++) {
				System.out.print(b[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println("Number of Page_faults for LRU Page Replacement Algorithm is :"+(k+1));
		//Optimal algorithm
		k=2;
		for(i=3;i<n;i++) {
			if(a[i]!=b[0][k] && a[i]!=b[1][k] && a[i]!=b[2][k]) {
				c1=0;c2=0;c3=0;b1=1;b2=1;b3=1;
				for(t=i+1;t<n;t++) {
					if(a[t]==b[0][k]) {
						while(b1>0) {
							c1=t;
							b1--;
						}
					}
					else if(a[t]==b[1][k]) {
						while(b2>0) {
							c2=t;
							b2--;
						}
					}
					else if(a[t]==b[2][k]) {
						while(b3>0) {
							c3=t;
							b3--;
						}
					}
					
				}
				if(c1==0 || c2==0 || c3==0) {
					if(c1==0) {
						count=0;
					}
					else if(c2==0) {
						count=1;
					}
					else if(c3==0) {
						count=2;
					}
				}
				else {
					if(c1>=c2) {
						if(c1>=c3) {
							count=0;
						}
						else
							count=2;
					}
					else {
						if(c2>=c3) {
							count=1;
						}
						else {
							count=2;
						}
					}
				}
				b[0][k+1]=b[0][k];
				b[1][k+1]=b[1][k];
				b[2][k+1]=b[2][k];
				b[count][k+1]=a[i];
				k++;
			}
		}
		//optimal display
		System.out.println();
		System.out.println("optimal PAGE FRAMES");
		for(i=0;i<3;i++) {
			for(j=0;j<=k;j++) {
				System.out.print(b[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println("Number of Page_faults for OPTIMAL Page Replacement Algorithm is :"+(k+1));
		
	}
		
		
		
}

