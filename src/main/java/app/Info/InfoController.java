package app.Info;

/**
 * Created by PC on 17.03.2017.
 */
import app.util.*;
import spark.*;
import java.util.*;
import static app.Application.*;

public class InfoController {
    public static Route serveInfoPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", userDao.getAllUserNames());
        model.put("book", bookDao.getRandomBook());
        return ViewUtil.render(request, model, Path.Template.INFO);
    };
}
