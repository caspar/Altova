(: Copyright (c) 2004 Altova GmbH, http://www.altova.com :)
(: Library Module containing some mathematical function declarations :)
(: Purpose: test library declaration, recursive user defined functions, numeric operators :)

xquery version "1.0" encoding "UTF-8";

module namespace math="http://www.xmlspy.com/xquery/math";

declare function math:NewtonIteration( $n, $k, $e )
{ 
	if ( abs(( $k * $k - $n) div $e ) < 1 ) then $k 
	                                        else math:NewtonIteration( $n, ( ( $k + $n div $k) div 2 ), $e )
};

declare function math:sqrt( $n )
{
  math:NewtonIteration( $n, 1, 0.000000000001 )
};

declare function math:EulerSum( $k  )
{
    sum( for $i in ( 1 to $k ) return 1 div ( $i * $i ) )
};

(:
(: recursive declaration of Euler sum :)
declare function math:EulerSumR( $k  )
{
    if ( $k = 1 ) then 
  	1 
    else 
  	( 1 div ($k*$k) + math:EulerSumR( $k - 1 ) )
};
:)

declare function math:Pi_Euler( $k  )
{
    math:sqrt( 6 * math:EulerSum( $k ) )
};

declare function math:VieteIteration( $x, $y, $k )
{
	if ( $k = 0 ) then 
		2*$x
	else
		math:VieteIteration( $x * $y, math:sqrt( 2 * $y div ($y + 1 ) ), $k - 1 )
};

declare function math:Pi_Viete( $k )
{
	let 
		$x0 := 1, 
		$y0 := math:sqrt(2) 
	return
		math:VieteIteration( $x0, $y0, $k )
};

declare variable $math:TestVariable := 7.5;
