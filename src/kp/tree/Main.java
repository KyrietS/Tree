package kp.tree;

public class Main {

    public static void main(String[] args)
    {
        Tree< Integer > tree = new Tree<>( 3 );
        tree.insert( 1 );
        tree.insert( 2 );
        tree.insert( 3 );

        tree.insert( 4 );

        p( tree.root.elem.get( 0 ).right.elem.size() );
//        Item i = (Item)tree.root.elem.get( 0 ).right.elem.get( 1 );
 //       p( i.value );
        //p( tree.root.elem.get( 0 ).right.elem.get(0) );

        //System.out.println( tree.root.elem.get( 1 ).value.toString() );
        //System.out.println( tree.root.elem.get( 2 ).value.toString() );
    }

    static void p( Object text )
    {
        System.out.println( text.toString() );
    }
}
