//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
   Document document=FactoryDemo.getDocument("word");//can pass pdf or excel also...
   if (document!=null) {
       document.open();
   }
}