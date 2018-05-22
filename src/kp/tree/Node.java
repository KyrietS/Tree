package kp.tree;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unchecked")
class Node< T extends Comparable<T> >
{
    private int size;
    public ArrayList<Item<T>> elem;
    public Node<T> parent;
    public boolean isLeaf = true;
    Node( int size, Node<T> parent )
    {
        this.size = size;
        this.parent = parent;
        this.elem = new ArrayList<>( size );
    }

    Node<T> addValue( T value )
    {
        if( !isLeaf ) //Node nie jest liściem, więc wkładamy value gdzieś niżej
        {
            for( int i = 0; i < elem.size(); i++ )
            {
                if( value.compareTo( elem.get(i).value ) < 0 )
                {
                    elem.get( i ).left.addValue( value );

                    return null;
                }
            }
            // Nie znaleziono większego, dodaj na prawo od największego.
            elem.get( elem.size()-1 ).right.addValue( value );
            return null;
        }
        else if( elem.size() < size ) // Jest miejsce, wsadzamy element i sortujemy.
        {
            Item<T> item = new Item<>( value );
            elem.add( item );
            elem.sort( Comparator.comparing( o -> o.value ) ); // Sotowanie listy po dodaniu elementu
            // TODO Przepięcie wskaźników w nowe miejsca
            return null;
        }
        else // Dzielimy node na pół
        {
            Node<T> newParent = new Node<>( size, parent );         // Nowy rodzic dwóch Node po podziale
            Node<T> newNode = new Node<>( size, newParent );
            // Przepisujemy elementy do nowego Node od size/2 (zaokrąglone w górę)
            for( int i = (int) Math.ceil((double) size / 2); i < size; i++ )
            {
                newNode.addValue( elem.get( i ).value );        // Dodajemy element do nowego Node
                elem.remove( i );                               // Usuwamy dodany element ze starego Node
            }
            newNode.addValue( value );
            newParent.addValue( newNode.elem.get(0).value );    // Dodanie środkowego elementu do nowego rodzica
            newParent.elem.get( 0 ).left = this;                // Podpięcie lewego wskaźnika
            newParent.elem.get( 0 ).right = newNode;            // Podpięcie prawego wskaźnika
            this.parent = newParent;                                // Ustawienie nowych rodziców
            newNode.parent = newParent;
            newParent.isLeaf = false;                           // Nowy rodzic nie jest już liściem, bo ma wskaźniki != null
            return newParent;
        }
    }

    void addItem( Item<T> item )
    {

    }

    /*void print( int intend )
    {
        for( int i = 0; i < elem.size(); i++ )
        {
            // Robienie wcięcia
            for( int j = 0; j < intend; j++ )
                System.out.print(" ");
            elem.get( i ).print( intend );
        }
    }*/

}
