package edu.wctc;

import java.util.HashSet;
import java.util.Set;

public class VennDiagram <T> {

    private String circle1;
    private String circle2;
    private String circle3;

    private Set<T> circle1Contents;
    private Set<T> circle2Contents;
    private Set<T> circle3Contents;

    public VennDiagram(String circle1, String circle2, String circle3) {

        this.circle1 = circle1;
        this.circle2 = circle2;
        this.circle3 = circle3;

        circle1Contents = new HashSet<>();
        circle2Contents = new HashSet<>();
        circle3Contents = new HashSet<>();

    }

    public void add(T item, String... labels)
    {

        for(int i = 0; i < labels.length; i++)
        {

            getCircleForLabel(labels[i]).add(item);


        }

    }

    public Set<T> diagramCenter()
    {

        circle1Contents.retainAll(circle2Contents);
        circle1Contents.retainAll(circle3Contents);
        return circle1Contents;

    }

    public Set<T> complementOf(String first, String second)
    {

         Set<T> firstSet = getCircleForLabel(first);
         Set<T> secondSet = getCircleForLabel(second);

         Set<T> firstSetHolder = new HashSet<>(firstSet);
         Set<T> secondSetHolder = new HashSet<>(secondSet);

         firstSetHolder.removeAll(secondSet);
         return firstSetHolder;

    }

    public Set<T> unionOf(String first, String second)
    {

         Set<T> firstSet = getCircleForLabel(first);
         Set<T> secondSet = getCircleForLabel(second);

         Set<T> firstSetHolder = new HashSet<>(firstSet);
         Set<T> secondSetHolder = new HashSet<>(secondSet);

         firstSetHolder.addAll(secondSetHolder);
         return firstSetHolder;

    }

    public Set<T> intersectionOf(String first, String second)
    {

        Set<T> firstSet = getCircleForLabel(first);
        Set<T> secondSet = getCircleForLabel(second);

        Set<T> firstSetHolder = new HashSet<>(firstSet);
        Set<T> secondSetHolder = new HashSet<>(secondSet);

        firstSetHolder.retainAll(secondSetHolder);
        return firstSetHolder;

    }

    private Set<T> getCircleForLabel(String label)
    {

        if(label.equals(circle1))
        {

            return circle1Contents;

        }

        if(label.equals(circle2))
        {

            return circle2Contents;

        }

        if(label.equals(circle3))
        {

            return circle3Contents;

        }
        else{

            return null;

        }

    }

}
