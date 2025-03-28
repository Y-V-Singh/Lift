/**
 * Child class of basic to acess the internal process of lift
 */
public class Help extends Basic
{
    void develop()
    { 
        for(int i=0;i<3;i++)
         sf[i]=(int)((Math.random()*(14+1)-1));         
         int gb[]={-1,1,0};
        for(int i=0;i<=2;i++)
        {
            if((i==0&&sf[0]==-1)||(i==1&&sf[1]==-1)||(i==2&&sf[2]==-1))
            {
                 sdir[i]=1;
                 sd[i]=(int)((Math.random()*(14-0))+0);;
            }
            else if((i==0&&sf[i]==14)||(i==1&&sf[i]==14)||(i==2&sf[i]==14))
             {
                 sdir[i]=-1;
                 sd[i]=(int)((Math.random()*(13+1))-1);;
            }
            else
            {
             int j=(int)((Math.random()*(3-0))+0);
             sdir[i]=gb[j];
            }
            if(sdir[i]==1)
             sd[i]=(int)((Math.random()*(14-sf[i]+1))+sf[i]+1);
            else if(sdir[i]==-1)
              sd[i]=(int)((Math.random()*(sf[i]-1+1))-1);
            else
             sd[i]=sf[i];
            if(i==0)
             System.out.println("Lift 1 is moving from "+sf[i]+" floor to "+sd[i]+"floor, thus the direction is "+sdir[i]);
            if(i==1)
             System.out.println("Lift 2 is moving from "+sf[i]+" floor to "+sd[i]+"floor, thus the direction is "+sdir[i]);
            if(i==2)
             System.out.println("Lift 3 is moving from "+sf[i]+" floor to "+sd[i]+"floor, thus the direction is "+sdir[i]); 
            }   
    }
}