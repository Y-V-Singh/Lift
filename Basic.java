/**
 * Code to depict working of Independent lift system
 */
import java.util.*;
public class Basic
{
   static int fl;
   static int dir;//direction of movement of lift
   static String s1="L1";//L1 is sf[0]
   static String s2="L2";//L2 is sf[1]
   static String s3="L3";//L3 is sf[2]
   static int sdir[]=new int[3];//1 is up, -1 is down and 0 is null
   static int sf[]=new int[3];
   static int sd[]=new int[3];//desination of lift
   public static void main()
   {    
        System.out.println("This is a code to guide the OS of a Lift in deciding which Lift must be sent to user.\nThere are three lifts L1,L2 and L3.\n The building have one basement and max 14 floor."); 
        Basic ob=new Basic();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter floor from which the user want to access the lift and input the direction using 1/-1 where,'1' to go up and '-1' to go down");
        fl=sc.nextInt();
        dir=sc.nextInt();
        if(fl>14||fl<-1)
        {
             System.out.println("Ilegitimate Request Established\nError code 903 Found..........\n--->Operaion terminaed");
             return;
        }
        Help ob2=new Help();
        ob2.develop();
        String x=ob.case1(sf,sd,sdir); 
        System.out.println("the Lift which arrived is:"+x);
   }       
   String case1(int ar[],int br[],int cr[])//sf,sd,sdir
   {
       int arr[]={0,0,0};
       int a,b,c;
       for(int i=0;i<3;i++)
       {
           if(cr[i]==0)
            arr[i]=Math.abs(fl-sf[i]);
           else if(ar[i]>fl&&sdir[i]==-1&&dir==1 )
           {
               if(br[i]>fl)
               {
                 arr[i]=sf[i]-sd[i]+sd[i]-fl+1;  
               }   
               else
                arr[i]=sf[i]-sd[i]+fl-sd[i]+1;
           }
           else if(ar[i]>fl)
           {
               if(br[i]>fl&&br[i]>sf[i])
               {
                 arr[i]=sd[i]-sf[i]+sd[i]-fl+1; 
               }
               else if(br[i]>fl&&br[i]<sf[i])
                arr[i]=sf[i]-sd[i]+sd[i]-fl+1;
               else
                arr[i]=sf[i]-fl;
           }
           else if(ar[i]<fl&& sdir[i]==1&&dir==1)
           {
               if(br[i]<fl)
                arr[i]=sd[i]-sf[i]+fl-sd[i]+1;
                else
                arr[i]=fl-sf[i];
           }       
           else if(ar[i]<fl)
           {
             if(br[i]>fl)
               {
                 arr[i]=sd[i]-sf[i]+sd[i]-fl+1; 
               }
               else if(sd[i]<sf[i])
                arr[i]=sf[i]-sd[i]+fl-sd[i]+1; 
                else
                arr[i]=sd[i]-sf[1]+1+fl-sd[i];
           }     
           else
           {}               
       }
       System.out.println("Now the ration of time taken by the Lift 1,2 and 3 to reach the user are in ratio->"+arr[0]+":"+arr[1]+":"+arr[2]);
       a=arr[0];b=arr[1];c=arr[2];
       String min = (Math.abs(a) < Math.abs(b)) ? (Math.abs(a) < Math.abs(c) ? "L1" : "L3") : (Math.abs(b) < Math.abs(c) ? "L2" : "L3");
       System.out.println("Therefore Control unit must send *GO* command to "+min+" because of its minimal time usage");
       return min; 
   }
}