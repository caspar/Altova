(: Copyright (c) 2004 Altova GmbH, http://www.altova.com :)
(: Test for imported functions and variables :)
(: Purpose: demonstrating library import, direct element constructors, computed content, for loops, sqrt  calculation etc.:)

xquery version "1.0" encoding "UTF-8";

declare boundary-space preserve;

declare default element namespace "http://www.altova.com";

import module namespace math="http://www.xmlspy.com/xquery/math" at "math.xq";

<demo_using_math>
    <sqrt_2>{  math:sqrt( 2 ) }</sqrt_2> 
    <sqrt_3>{  math:sqrt( 3 ) }</sqrt_3> 
    <module_variable>$math:TestVariable={$math:TestVariable}</module_variable>
    <pi_Eulersum>{math:Pi_Euler( 70 )}</pi_Eulersum>
    {
        for $i in ( 1 to 7 ) return 
            document {<pi_Viete recursion_level="{$i}">{ 
                substring( string( math:Pi_Viete ( $i ) ), 1, 15 ) 
            }
    </pi_Viete>
            }
    }
</demo_using_math>
