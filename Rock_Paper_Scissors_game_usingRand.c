#include<stdio.h>
#include<stdlib.h>
int main()
{
int p=0,c=0,x,y,i;
char s[20];
printf("enter name");
gets(s);
for(i=0;i<3;i++)
{
printf("enter 0 for rock,1 for paper,2 for scissor");
printf("enter value of x");
scanf("%d",&x);
y=(rand()%3);
printf("x=%d\ty=%d\n",x,y);
if(x==y)
{p++,c++;}
if(x==0 && y==1)
{c++;}
if(x==0 && y==2)
{p++;}
if(x==1 && y==2)
{c++;}
if(x>2)
{
printf("invalid number you lost the game");
break;
}
}
printf("p=%d\tc=%d\n",p,c);
printf("%s\n",s);
if(p>c)
{printf("you won");}
else if(p<c)
{printf("you lose");}
else if(p==c)
{printf("draw game");}
return 0;
}
