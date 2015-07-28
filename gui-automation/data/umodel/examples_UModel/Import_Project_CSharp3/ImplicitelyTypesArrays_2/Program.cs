// name:    Program.cs
// project: ImplicitelyTypesArrays_2.csproj
// author:  baa
// date:    2008-01-07
// spec:    7.5.10.4 Array creation expressions
// desc:    The syntax of array creation expressions is etxended to support typed array 
//          creation expressions
//          keyword new[] used as class variable as well as local

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AnonymousTypes_1
{
    class Program
    {
        //  Implicitly typed array creation expressions can be combined with 
        //  anonymous object initializers to create anonymously typed data structures.
        // used type has to be object[]
        public object[] p2 = new[] {
                   new {
                        Name = "Chris Smith",
                        PhoneNumbers = new[] { "206-555-0101", "425-882-8080" }
                   },
                   new {
                        Name = "Bob Harris",
                        PhoneNumbers = new[] { "650-555-0199" }
                   }
                };    
  

        static void Main(string[] args)
        {
            // locally defined implicitely typed arrays
           
            var p1 = new[] {
                   new {
                        Name = "Chris Smith",
                        PhoneNumbers = new[] { "206-555-0101", "425-882-8080" }
                   },
                   new {
                        Name = "Bob Harris",
                        PhoneNumbers = new[] { "650-555-0199" }
                   }
                };    
  
            
            
            
            Console.WriteLine("test");
            Console.ReadLine();
        }
    }

   


}
