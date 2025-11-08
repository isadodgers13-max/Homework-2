@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        // show links, maybe recent classes/students
        return "home";
    }
}
