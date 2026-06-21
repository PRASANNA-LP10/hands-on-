import java.util.Scanner;

class Main{//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    new Product(101,"Product1","Category1");
    new Product(102,"Product2","Category2");
    new Product(103,"Product3","Category3");
    new Product(104,"Product4","Category4");
    new Product(105,"Product5","Category5");
    new Product(106,"Product6","Category6");
    new Product(107,"Product7","Category7");
    new Product(108,"Product8","Category8");
    new Product(109,"Product9","Category9");
    new Product(110,"Product10","Category10");

    Scanner sc=new Scanner(System.in);

    int id=sc.nextInt();
    System.out.println(TestProductSearch.linearsearch(id));
    System.out.println(TestProductSearch.binarysearch(id));
    }
}
