@Controller
@RequestMapping("/classes")
public class SwimClassController {
    private final SwimClassService classService;
    private final StudentService studentService;

    public SwimClassController(SwimClassService classService, StudentService studentService) {
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classService.findAll());
        return "classes/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("swimClass", new SwimClass());
        return "classes/new";
    }

    @PostMapping("/new")
    public String createClass(@Valid @ModelAttribute("swimClass") SwimClass swimClass, BindingResult br) {
        if (br.hasErrors()) return "classes/new";
        classService.save(swimClass);
        return "redirect:/classes";
    }

    // Assign students: show form
    @GetMapping("/{id}/assign")
    public String showAssignForm(@PathVariable Long id, Model model) {
        SwimClass swimClass = classService.findById(id);
        model.addAttribute("swimClass", swimClass);
        model.addAttribute("students", studentService.findAll());
        return "classes/assign";
    }

    @PostMapping("/{id}/assign")
    public String assignStudents(@PathVariable Long id,
                                 @RequestParam(required = false) List<Long> studentIds) {
        SwimClass swimClass = classService.findById(id);
        if (studentIds != null) {
            Set<Student> chosen = studentIds.stream()
                .map(studentService::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
            swimClass.setStudents(chosen);
            classService.save(swimClass);
        } else {
            swimClass.getStudents().clear();
            classService.save(swimClass);
        }
        return "redirect:/classes";
    }
}
