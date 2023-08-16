package StacksAndQueses;

public class DynamicStack extends CustomStack{ // will never be full

    public DynamicStack() {
        super(); // will call the constructor in the parent class that doesn't take any argument
    }

    public DynamicStack(int size) {
        super(size); // it will call CustomStack(int size)
    }

    @Override // for using push function of CustomStack
    public boolean push(int item) {
        // this take care of it being full
        if(this.isFull()){
            //double the array size
            int temp[] = new int[data.length*2];
            //copy all items in new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        // insert item
        // now we know that if array is full or not
        return super.push(item);
    }
}
