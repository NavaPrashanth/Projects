#include<stdio.h>
#include<stdlib.h>
#include<process.h>
//family details
struct details
{
        char N[8][20];
        int A[12],n,D,cost;
}G;
int a[16],B[16];
void writeinf(int h)
{
	int i,n=0;
	FILE *fp;
    fp=fopen("customer_details.dat","w");
			printf("\nenter no.of persons");
			scanf("%d",&G.n);
			for(i=0;i<G.n;i++)
			{
				printf("\nenter persons name");
				scanf("%s",G.N[i]);
			}
			printf("\nenter Adhar number");
			for(i=0;i<12;i++)
			{
				printf("\nenter number");
				scanf("%d",&G.A[i]);
			}
			printf("\nenter number of days staying at hotel");
			scanf("%d",&G.D);
			if(h==1)
				G.cost=G.D*10000+115;
			else
				G.cost=G.D*7000;
			fwrite(&G,sizeof(struct details),1,fp);
			printf("\nThe room service has been alloted");
			fclose(fp);
			
}
void history_vistors()
{
	FILE *fp;
	int i,c=0;
	char a[3];
		printf("enter password");
		scanf("%s",a);
      	if(a[0]=='v' && a[1]=='c' && a[2]=='e')
		c=c+1;
	if(c==1)
	{
		fp=fopen("customer_details.dat","r");
		if(fp==NULL)
    {
        printf("can't read file");
        exit(1);
    }
        while(fread(&G,sizeof(G),1,fp)==1)
        {
			for(i=0;i<G.n;i++)
			{
				printf("\npersons name %s",G.N[i]);
				scanf("%s",G.N[i]);
			}
		/*	printf("\nAdhar number is :");
			for(i=0;i<12;i++)
			{
				printf("%1d",&G.A[i]);
			}
			printf("\n No.of days staied%d :",G.D);
            printf("\nBill:= %d",G.cost);*/
            printf("\n\n");
        }
	}
	else
		exit(1);
fclose(fp);
}
		
void Hotel_Room()
{
	int t,h,b,C1=0,C2=0,r,i,s,m,a[16],B[16];
	char S[16][16],c,ch;
	FILE *f,*fptr;
	printf("\nAC rooms are available in 3rd & 4th floors NON-AC rooms are available in 1st & 2nd floors\nFor AC rooms press-1 and For NON-AC rooms press-2");
	scanf("%d",&h);
	if(h==1)
	{
		printf("\nThe AC rooms that are availabile are:");
		fptr=fopen("rooms.txt","r+");
		f=fopen("service.txt","r+");
		fseek(fptr,8,0);
		fseek(f,8,0);
		//m=ftell(fptr);
		//printf("%d",m);
		for(i=8;i<16;i++)
		{
			ch=fgetc(f);
			b=atoi(&ch);
			B[i]=b;
		}
		for(i=8;i<16;i++)
		{
			ch=fgetc(fptr);
			b=atoi(&ch);
		//	printf("%d",b);
			a[i]=b;
		}
		for(i=8;i<12;i++)
			printf("%d",a[i]);
		for(i=8;i<12;i++)
		{
			if(a[i]==0)
			{
				printf("\n The room %d is available",293+i);
			}
			else
				C1++;
		}
		for(i=12;i<16;i++)
		{
			if(a[i]==0)
			{
				printf("\n The room %d is available",389+i);
			}
			else
				C1++;
		}
		if(C1==8)
			printf("\nNO AC room is avaiable");
		else
			{
			printf("\nEnter available room ");
			scanf("%d",&r);
			if(r>300 && r<305)
			{
				t=7+r-300;
				fseek(fptr,t,0);
				m=ftell(fptr);
				printf("%d",m);
				fseek(f,t,0);
				fprintf(f,"1");
				fprintf(fptr,"1");
				writeinf(1);
			}
			else if(r>400 && r<405)
			{	
				t=11+r-400;
				fseek(f,t,0);
				fseek(fptr,t,0);
				fprintf(f,"1");
				fprintf(fptr,"1");
				writeinf(1);
			}
		}
		
	}	
	if(h==2)
	{
		printf("\nThe NON-AC rooms that are availabile are:");
		rewind(fptr);
		rewind(f);
		for(i=0;i<8;i++)
			{
			ch=fgetc(fptr);
			b=atoi(&ch);
			a[i]=b;
		}
		for(i=0;i<8;i++)
		{
			ch=fgetc(f);
			b=atoi(&ch);
			B[i]=b;
		}
		for(i=0;i<4;i++)
		{
			if(a[i]==0)
				printf("\n The room %d is available",101+i);
			else
				C2++;
		}
		for(i=4;i<8;i++)
		{
			if(a[i]==0)
				printf("\n The room %d is available",197+i);
			else
				C2++;
		}
		if(C2==8)
			printf("\nNO NON-AC room is avaiable");
		else if(C1==8 && C2==8)
		{
			printf("\nNo room is available");
			exit(1);
		}
		else
		{
			printf("\nEnter available room ");
			scanf("%d",&r);
			if(r>100 && r<105)
			{	
				t=r-101;
				fseek(f,t,0);
				fseek(fptr,t,0);
				fprintf(f,"1");
				fprintf(fptr,"1");
				writeinf(1);
			}
			else if(r>200 && r<205)
			{	
				t=3+r-200;
				fseek(f,t,0);
				fseek(fptr,t,0);
				fprintf(f,"1");
				fprintf(fptr,"1");
				writeinf(1);
			}
		}
	}
}		
void menu()
	{
	int i,n;
	FILE *fptr;
	char c;
	while(1)
	{
		printf("\n enter 1-Tiffins 2-Lunch 3-Dinner 4-exit");
		scanf("%d",&n);
		switch(n)
		{
			case 1:fptr=fopen("tiffins.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
				fclose(fptr);
				break;
			case 2:printf("\nLUNCH available enter 1-Indian food 2-Continental food 3-Chinese food");
				   scanf("%d",&i);
				   if(i==1)
				   {
						fptr=fopen("indianfood.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
					if(i==2)
				   {
						fptr=fopen("continentalfood.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
					if(i==3)
				   {
						fptr=fopen("chinesefood.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
				break;
			case 3:printf("\nDINNER available enter 1-Indian food 2-Continental food 3-Chinese food");
				   scanf("%d",&i);
				   if(i==1)
				   {
						fptr=fopen("indianfood.txt","r");
					if (fptr == NULL)
						{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
					if(i==2)
				   {
						fptr=fopen("continentalfood.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
					if(i==3)
						 {
						fptr=fopen("chinesefood.txt","r");
					if (fptr == NULL)
					{
						printf("Cannot open file \n");
						exit(0);
					}
					c = fgetc(fptr);
					while (c != EOF)
					{
						printf ("%c", c);
						c = fgetc(fptr);
					}
					fclose(fptr);
					}
				break;
			case 4:exit(1);
		}
	}
}
int main()
{
	int a[15],t,h,b,C1=0,C2=0,r,i,s;
        char c;
        FILE *fptr;
        printf("\nThese are the facilites provided by our Hotel\n  ");
        fptr = fopen("facili.txt", "r");
        if (fptr == NULL)
        {
                printf("Cannot open file \n");
		exit(0);
        }
        c = fgetc(fptr);
        while (c != EOF)
       {
        printf ("%c", c);
        c = fgetc(fptr);
        }
        fclose(fptr);
		do
		{
			printf("\nenter 1-for room booking 2-checking history 3-food menu booking 4-exit");
			scanf("%d",&h);
			switch(h)
			{
				case 1: Hotel_Room();
						break;
				case 2: history_vistors();
						break;
				case 3: menu();
						break;
				case 4: exit(1);
			}
		}
		while(h != 4);
	return 0;
}