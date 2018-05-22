package kp.tree;

public class Tree< T extends Comparable<T> >
{
    private int size;
    public Node<T> root;
    Tree( int size )
    {
        this.size = size;
        root = new Node<>( size, null );
    }

    void insert( T value )
    {
        Node<T> newRoot = root.addValue( value );
        if( newRoot != null )
            root = newRoot;
    }

    void print()
    {
        System.out.println("Drzewo rozmiar: " + size );
    }
}
