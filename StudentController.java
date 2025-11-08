@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final SwimClassService swimClassService;

    public StudentController(StudentService studentService, SwimClassService swimClassService) {
        this.studentService = studentService;
        this.swimClassService = swimClassService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult br, Model model) {
        if (br.hasErrors()) return "students/register";
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "students/view";
    }
}
