package kp.tree;

class Item< T extends Comparable<T> > implements Comparable<T>
{
    public T value;
    Node left = null;
    Node right = null;
    Item( T value )
    {
        this.value = value;
    }

    @Override
    public int compareTo( T o )
    {
        return this.value.compareTo( o );
    }


}
