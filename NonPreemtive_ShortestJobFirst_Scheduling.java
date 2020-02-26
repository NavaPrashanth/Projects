package sjf;
import java.util.*;
public class NPsjf {
	int n;
	int pInfo[][];
	int rq[];
	int at,bt,i1=0,i2=0;
	float tat,wt;
	Scanner sc = new Scanner(System.in);
	public NPsjf(){
		System.out.println("Enter no.of processes");
		n=sc.nextInt();
		pInfo=new int[6][n];
		rq=new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter processes arival time:");
			at=sc.nextInt();
			pInfo[0][i]=at;
			rq[i]=0;
		}
		for(int i=0;i<n;i++){
			System.out.println("Enter processes brust time:");
			bt=sc.nextInt();
			pInfo[1][i]=bt;
			pInfo[5][i]=bt;
		}
		for(i1=0;i1<n;i1++){
			i2+=pInfo[1][i1];
		}
		scheduling();
		
	}
	public void scheduling(){
		System.out.println("in scheduling");
		int j1 = 0,max;
		//int j2 = 0;
		int time=0,timec = -1;
		//int t = -1;
		int sum = 0;
		int status = 1;
		int []chart=new int[i2];
		int min = 0;
		while(status != 0){

			sum=0;
			max=512;
			for(j1=0;j1<n;j1++){
				if((pInfo[0][j1]<=time)&&(pInfo[5][j1]!=0))
					rq[j1]=1;
				if(pInfo[5][j1]==0)
					rq[j1]=0;
			}
			for(j1=0;j1<n;j1++){
				if(rq[j1]==1){
					if(pInfo[5][j1]<max){
						max=pInfo[5][j1];
						min=j1;
					}
				}
			}
			chart[++timec]=min;
			pInfo[5][min]--;
			if(pInfo[5][min]==0){
				pInfo[2][min]=timec + 1;
			}
			time++;
			
			for( int i = 0; i < n; i++){
				if(pInfo[5][i] == 0)
					sum += 1;
			}
			
			if(sum == n)
				status = 0;
			
	}
	
		for(int i = 0; i < n; i++){
			pInfo[3][i] = pInfo[2][i] - pInfo[0][i];
			pInfo[4][i] = pInfo[3][i] - pInfo[1][i];
		
			tat += pInfo[3][i];
			wt += pInfo[4][i];
		}
	
		tat = tat/n;
		wt = wt/n;
		
		
		System.out.println("Tat :"+tat);
		System.out.println("Wt :"+wt);
		System.out.println("arrival time :");
		for( int i = 0; i < n; i++)
			System.out.println(pInfo[0][i]);
		
		System.out.println("burst time :");
		for( int i = 0; i < n; i++)
			System.out.println(pInfo[1][i]);
		
		System.out.println("completion time :");
		for( int i = 0; i < n;i++)
			System.out.println(pInfo[2][i]);
		
		System.out.println("tat time :");
		for( int i = 0; i < n;i++)
			System.out.println(pInfo[3][i]);
		
		System.out.println("wt :");
		for( int i = 0; i < n; i++)
			System.out.println(pInfo[4][i]);
		
		System.out.println("Gantt chart :");
		for( int i = 0; i < timec+1; i++)
			System.out.print(chart[i]+"");
	}
	
	public static void main(String []args){
		new NPsjf();
	}
}	
