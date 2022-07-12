

 
import java.util.ArrayList;

public class bill{
    ArrayList <item> itemList= new ArrayList();
    double subTotal,CGST,SGST,grandTotal;
    bill(){
        subTotal=0;
    }
    Double quickCalc(double q, double p){
        double cg=0,sg=0,t=0,gt=0;
        t=q*p;
        sg=(0.09*t);
        cg=sg;
        gt=t+sg+cg;
        return gt;
    }
    void addItem(double q,double p){
        itemList.add(new item(q,p));
        update();
    }
    void update(){
        subTotal=0;
        for(int i=0;i<itemList.size();i++){
            subTotal+=itemList.get(i).total;
        }
        subTotal=Math.round(subTotal);
        CGST=Math.round(0.09*subTotal);
        SGST=Math.round(0.09*subTotal);
        grandTotal=Math.round(CGST+SGST+subTotal);
    }
    void listItems(){
        for(int i=0;i<itemList.size();i++){
            System.out.print("Quantity of item "+(i+1)+":\t"+Math.round(itemList.get(i).quantity)
            +" /-\n"+"price of item :"+(i+1)+":\t"+Math.round(itemList.get(i).price)+" /-\n"
            +"total from item "+(i+1)+":\t"+Math.round(itemList.get(i).total)+" /-\n\n\n");
        }
    }
    String getList(){
        String str="";
        for(int i=0;i<itemList.size();i++){
            str = str + ("Quantity of item "+(i+1)+":\t"+Math.round(itemList.get(i).quantity)
            +" /-\n"+"price of item :"+(i+1)+":\t\t"+Math.round(itemList.get(i).price)+" /-\n"
            +"total from item "+(i+1)+":\t"+Math.round(itemList.get(i).total)+" /-\n\n\n");
        }
        return str;
    }
    void makeBill(){
        listItems();
        System.out.print("subtotal:\t"+Math.round(subTotal)+
        " /-\nCGST:\t"+Math.round(CGST)+
        " /-\nSGST:\t"+Math.round(SGST)+
        " /-\nGrandtotal:\t"+Math.round(grandTotal)+"/-");
    }
    void clearAll(){
        itemList.removeAll(itemList);
        update();
    }
    String billstring(){
        return ("subtotal:\t"+Math.round(subTotal)+
        " /-\nCGST:\t\t"+Math.round(CGST)+
        " /-\nSGST:\t\t"+Math.round(SGST)+
        " /-\nGrandtotal:\t"+Math.round(grandTotal)+"/-");
    }
    String billHeader(){
        String str="ARMAAN ENTERPRISES\nManufacturer Trading of Iron Door, Chaukhat, Palla, Maharaja Gate Etc.\n GST:09ADNPV1603N1ZZ\nMob. :+91 9415729020\nH.O.H. 68,PURANI BASTI NAUBASTA, HAMIRPUR ROAD, KANPUR\nBRANCH-42, HAMIRPUR ROAD, NAUBASTA, KANPUR\n--------------------------------------------\n";
        return str;
    }
}