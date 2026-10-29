 /**
 * AP CSA Lab 2.1-2.3 - Boolean Expressions and if Statements
 *
 * Fill in the body of each method in SelectionLab below. Do not rename
 * anything, do not change the parameter lists, and do not change the return
 * types. The grader compiles against these exact signatures.
 *
 * Every part is one piece of TicketKiosk, the movie-ticket program from your
 * notes (Appendix A). The prices and rules are the same ones:
 *
 *     a matinee (before hour 17) is $9.00; an evening show is $13.00
 *     a child (12 or under) saves $3.00; a senior (65 or over) saves $4.00
 *     3D adds $3.50
 *
 * Money is kept in whole cents, so 1350 means $13.50. Each part tells you
 * which lines of TicketKiosk it matches, so you can look back at them.
 *
 * Run the program with:  mvn -q compile exec:java
 * Or from your IDE, just run main.
 */
public class SelectionLab
{
    // ---------------------------------------------------------------
    // PART 1: a relational operator gives back true or false
    //
    // Return true if a guest of this age is a child, and false otherwise.
    // A child is 12 or under, so 12 counts as a child and 13 does not.
    //
    // TicketKiosk line 37:   boolean isChild = age <= 12;
    //
    // An expression involving relational operators evaluates to a Boolean
    // value. That means you do not need an if statement here at all: the
    // comparison IS the answer, so you can return it directly.
    //
    //     return age <= 12;
    //
    // The six relational operators are  ==  !=  <  >  <=  >=
    //
    // Example: isChild(5)  is true
    // Example: isChild(12) is true
    // Example: isChild(13) is false
    //
    // Careful: age < 12 looks right but leaves 12-year-olds out. < does not
    // include the value itself; <= does.
    // ---------------------------------------------------------------
    public static boolean isChild(int age)
    {
        // TODO Part 1: return a Boolean expression that is true for 12 and under
        return age <= 12;
    }

    // ---------------------------------------------------------------
    // PART 2: the boundary value decides < or <=
    //
    // Return true if a show that starts at this hour is a matinee, and false
    // otherwise. A matinee starts BEFORE hour 17. Hours run 0 to 23, so
    // hour 17 is 5:00 in the evening.
    //
    // TicketKiosk line 39:   boolean isMatinee = hour < 17;
    //
    // Example: isMatinee(11) is true
    // Example: isMatinee(16) is true
    // Example: isMatinee(17) is false
    //
    // Careful: a show at hour 17 is NOT a matinee, because 17 < 17 is false.
    // Check your answer with the boundary value itself every time.
    // ---------------------------------------------------------------
    public static boolean isMatinee(int hour)
    {
        // TODO Part 2: return a Boolean expression that is true before hour 17
        return hour < 17;
    }

    // ---------------------------------------------------------------
    // PART 3: == on two Strings compares object references
    //
    // The kiosk asks "3D showing? (y/n): " and the guest types a word.
    // Return true if what they typed is exactly the lowercase letter y, and
    // false for anything else.
    //
    // TicketKiosk line 40:   boolean wants3D = choice3D.equals("y");
    //
    // == and != compare values. With primitive types, like int, that is the
    // actual value. With reference types, like String, it compares the object
    // REFERENCES -- whether the two names refer to the very same object -- not
    // the characters inside. Every word a guest types is a brand-new String
    // object, so choice == "y" is false even when the guest typed y. Compare
    // String contents with equals (Topic 1.15).
    //
    // Example: wants3D("y")   is true
    // Example: wants3D("n")   is false
    // Example: wants3D("Y")   is false  (equals is case-sensitive)
    // Example: wants3D("yes") is false
    //
    // Careful: choice == "y" may even look like it works when you test it in
    // main with the literal "y", because Java shares one copy of a repeated
    // literal. The grader hands you a new String, the way a Scanner does, so
    // == fails there.
    // ---------------------------------------------------------------
    public static boolean wants3D(String choice)
    {
        // TODO Part 3: compare the characters of choice with "y"
        return choice.equals("y");
    }

    // ---------------------------------------------------------------
    // PART 4: two-way selection with if-else
    //
    // Return the starting price, in cents, of a ticket for a show that starts
    // at this hour: 900 for a matinee (before hour 17), 1300 for anything
    // else.
    //
    // TicketKiosk lines 51-59:
    //
    //     int cents;
    //     if (isMatinee)
    //     {
    //         cents = 900;
    //     }
    //     else
    //     {
    //         cents = 1300;
    //     }
    //
    // A two-way selection (if-else) has two segments of code. The body of the
    // if runs when the Boolean expression is true, the body of the else runs
    // when it is false, and exactly one of the two always runs.
    //
    // Example: startingPrice(11) is 900
    // Example: startingPrice(17) is 1300
    // Example: startingPrice(21) is 1300
    //
    // Careful: hour 17 is an evening show, so startingPrice(17) is 1300.
    // Use the same comparison you wrote in Part 2.
    // ---------------------------------------------------------------
    public static int startingPrice(int hour)
    {
        // TODO Part 4: use if-else to return 900 or 1300
        int cents;
        if (hour < 17)
        {
            cents=900;
        }
        else
        {
            cents=1300;
        }
        return cents;
    }

    // ---------------------------------------------------------------
    // PART 5: one-way selection with if
    //
    // You are given a price in cents. Return that price with the 3D
    // surcharge, 350 cents, added if the guest chose 3D. If the guest did not
    // choose 3D, return the price unchanged.
    //
    // TicketKiosk lines 79-82:
    //
    //     if (wants3D)
    //     {
    //         cents += 350;
    //     }
    //
    // A one-way selection (if) has one segment of code, and the body runs
    // only when the Boolean expression is true. When it is false the body is
    // skipped, and the program carries on with the next statement after it.
    // There is no else here, because "no 3D" means "do nothing".
    //
    // wants3D is already a boolean, so it can be the whole condition. You do
    // not need to write wants3D == true.
    //
    // Example: addSurcharge(1300, true)  is 1650
    // Example: addSurcharge(1300, false) is 1300
    // Example: addSurcharge(600, true)   is 950
    //
    // Careful: return the price in BOTH cases. If the guest did not choose
    // 3D, the answer is the price you were given, not 0. And put no
    // semicolon after the parentheses: if (wants3D); is a complete if
    // statement with an empty body, so the { cents += 350; } block below it
    // is no longer part of the if and runs every time.
    // ---------------------------------------------------------------
    public static int addSurcharge(int cents, boolean wants3D)
    {
        // TODO Part 5: add 350 only when wants3D is true, then return the price
        if (wants3D=(true)) 
        {
            cents = 900;
        } 
        else 
        {

           cents += 350; 
        }
        return cents;
    }

    // ---------------------------------------------------------------
    // PART 6: the order of the steps changes the answer
    //
    // Return the price, in cents, of one ticket, following TicketKiosk's
    // steps 3 to 5 IN THIS ORDER:
    //
    //     step 3: start from the matinee price (900) or the evening
    //             price (1300)
    //     step 4: take off 300 for a child (12 or under), or 400 for a
    //             senior (65 or over)
    //     step 5: add 350 if the guest chose 3D
    //
    // An algorithm is built from sequencing, selection and repetition.
    // Here the steps are SEQUENCED -- done one at a time, in order -- and
    // each step is a SELECTION. The order in which they are used contributes
    // to the outcome of the algorithm.
    //
    // You may call your own methods from Parts 1, 2, 4 and 5 here, or write
    // the expressions out again. A guest can never be both a child and a
    // senior, so two separate one-way if statements are enough for step 4.
    //
    // Example: ticketCents(30, 19, false) is 1300  (adult, evening, 2D)
    // Example: ticketCents(70, 19, false) is 900   (1300 - 400)
    // Example: ticketCents(8, 11, true)   is 950   (900 - 300 + 350)
    //
    // Careful: this is the order mistake from the notes. If you take the age
    // discount off BEFORE you set the starting price, setting the price
    // replaces whatever was there, and the discount is lost: a senior at an
    // evening show is charged 1300 instead of 900.
    // ---------------------------------------------------------------
    public static int ticketCents(int age, int hour, boolean wants3D)
    {
        // TODO Part 6: steps 3, 4 and 5, in that order
        return 0;
    }

    // ---------------------------------------------------------------
    // PART 7: a one-way if fixes the zero that would go missing
    //
    // Return a price in cents as the receipt shows it: a dollar sign, the
    // dollars, a dot, and ALWAYS two digits of cents.
    //
    // TicketKiosk lines 114-119:
    //
    //     String price = "$" + cents / 100 + ".";
    //     if (cents % 100 < 10)
    //     {
    //         price += "0";
    //     }
    //     price += cents % 100;
    //
    // cents / 100 is integer division, so it gives the whole dollars, and
    // cents % 100 is the remainder, the cents left over (Topic 1.3).
    //
    // Example: formatPrice(1650) is "$16.50"
    // Example: formatPrice(900)  is "$9.00"
    // Example: formatPrice(1305) is "$13.05"
    // Example: formatPrice(610)  is "$6.10"
    //
    // Careful: without the if, 900 comes out "$9.0" and 1305 comes out
    // "$13.5", because the number 0 or 5 prints as one digit. The extra "0"
    // is added only when the cents part is under 10 -- so 610 must NOT get
    // one, or it would read "$6.010".
    // ---------------------------------------------------------------
    public static String formatPrice(int cents)
    {
        // TODO Part 7: build the price String, adding a "0" only when needed
        return "";
    }

    // ---------------------------------------------------------------
    // Run this to see your own work. The grader does not test main, so you
    // may change it freely while you experiment.
    // ---------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("isChild(12)                = " + isChild(12));
        System.out.println("isMatinee(17)              = " + isMatinee(17));

        // new String builds a separate object, the way a Scanner does when a
        // guest types y. A plain "y" literal would hide an == mistake.
        System.out.println("wants3D(new String(\"y\"))   = " + wants3D(new String("y")));

        System.out.println("startingPrice(11)          = " + startingPrice(11));
        System.out.println("addSurcharge(1300, true)   = " + addSurcharge(1300, true));
        System.out.println("ticketCents(70, 19, false) = " + ticketCents(70, 19, false));
        System.out.println("formatPrice(900)           = " + formatPrice(900));

        // The notes' sample run: age 15, hour 21, 3D, before the promo code.
        System.out.println();
        System.out.println("Total before promo: " + formatPrice(ticketCents(15, 21, true)));
    }
}
