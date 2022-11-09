package test;

import demo.lombok.model.Person;
import demo.lombok.model.User;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuilderTest {

    @Test public void testPersonBuilder () {
        final Person adam = Person.builder ()
                                  .name ("Adam Savage")
                                  .age (47)
                                  .job ("MythBusters")
                                  .job ("Unchained Reaction")
                                  .build ();

        assertEquals ("Adam Savage", adam.getName ());
        assertEquals (47, adam.getAge ());

        final Set<String> jobs = adam.getJobs ();
        assertEquals (2, jobs.size ());
        assertTrue (jobs.contains ("MythBusters"));
        assertTrue (jobs.contains ("Unchained Reaction"));
    }

    @Test public void testUserBuilder () {
        final User bob = User.create ()
                             .id ("1234")
                             .name ("Bob De Buildeur")
                             .dept ("Construction")
                             .salary (50000)
                             .create ();

        assertEquals ("User id mismatch", "1234", bob.getId ());
        assertEquals ("User name mismatch", "Bob De Buildeur", bob.getName ());
        assertEquals ("Department mismatch", "Construction", bob.getDept ());
        assertEquals ("Salary mismatch", 50000, bob.getSalary ());
    }

    @Test (expected = NullPointerException.class) public void nanananananananaNullMan () {
        /*
         remember how the 'id' field has a '@NonNull' annotation? Well we're not setting an id here.
         At some point, Lombok should throw a fit about that id field being null.
          */
        final User nullMan = User.create ()
                                 .name ("Null Man").create ();
    }
}