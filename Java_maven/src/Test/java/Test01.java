import Dao.Impl.findUserImpl;
import Dao.findUser;
import domain.User;
import org.junit.Test;

import java.util.List;

public class Test01 {
@Test
    public void Test001(){
        findUser findUser = new findUserImpl();
        List<User> all = findUser.findAll();
        System.out.println(all);

    }
}
