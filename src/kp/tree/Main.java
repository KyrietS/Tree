package kp.tree;

import java.io.IOException;

class Drzewo< T extends Comparable<T> >
{
    void compare( T a, T b )
    {
        if( a.compareTo( b ) < 0 )
            System.out.println( a.toString() + " < " + b.toString() );
        if( a.compareTo( b ) == 0 )
            System.out.println( a.toString() + " = " + b.toString() );
        if( a.compareTo( b ) > 0 )
            System.out.println( a.toString() + " > " + b.toString() );
    }
}

public class Main {

    public static void main(String[] args)
    {
//        Drzewo< Integer > d = new Drzewo<>();
//        d.compare( 1, 2 );
//        d.compare( 2, 1 );
//        d.compare( 3, 3 );
//
//        try{ System.in.read(); } catch( IOException ignore ){}


        BTree<String> a = new BTree<>( 3 );
        a.insert( "G" );
        a.insert( "F" );
        a.insert( "E" );
        a.insert( "D" );
        a.insert( "C" );
        a.insert( "B" );
        a.insert( "A" );
        a.remove( "D" );
        System.out.println( "Traversal drzewa z napisami:" );
        a.traverse();
        System.out.println();


        BTree<Integer> t = new BTree<>( 3 );
        t.insert( 1 );
        t.insert( 3 );
        t.insert( 7 );
        t.insert( 10 );
        t.insert( 11 );
        t.insert( 13 );
        t.insert( 14 );
        t.insert( 15 );
        t.insert( 18 );
        t.insert( 16 );
        t.insert( 19 );
        t.insert( 24 );
        t.insert( 25 );
        t.insert( 26 );
        t.insert( 21 );
        t.insert( 4 );
        t.insert( 5 );
        t.insert( 20 );
        t.insert( 22 );
        t.insert( 2 );
        t.insert( 17 );
        t.insert( 12 );
        t.insert( 6 );

        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove( 6 );
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove( 13 );
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove(7);
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove(4);
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove( 2 );
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

        t.remove( 16 );
        System.out.println( "Traversal of tree constructed is");
        t.traverse();
        System.out.println();

    }
}
