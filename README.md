# Monge Framework

This framework was made to make CRUD development easier. With Monge you have only to map your entity and implement your controller.

#### How to Use:

__Map your Entity:__

    @Document(collection = "tasks")
    public class Register extends BaseEntity{
    
        @Id
        private String idRegister;
        private Date dateTime;
        private Date modified;
        private User user;
    
        public User getUser() {
            return user;
        }
    
        public Register setUser(User user) {
            this.user = user;
            return this;
        }
    
        public String getIdRegister() {
            return idRegister;
        }
    
        public Register setIdRegister(String idRegister) {
            this.idRegister = idRegister;
            return this;
        }
    
        public Date getDateTime() {
            return dateTime;
        }
    
        public Register setDateTime(Date dateTime) {
            this.dateTime = dateTime;
            return this;
        }
    
        public Date getModified() {
            return modified;
        }
    
        public Register setModified(Date modified) {
            this.modified = modified;
            return this;
        }
    }

_Note that you have to extend from BaseEntity_

__Implement your Controller__:

    @RestController
    @RequestMapping("/register")
    public class RegisterController {
    
    
        @Autowired
        CrudService<Register> crudService;
    
        @RequestMapping(method = RequestMethod.GET)
        public Iterable<Register> get() {
            return crudService.list();
        }
    
    
        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<?> post(@RequestBody Register register) {
            crudService.add(register);
    
            HttpHeaders httpHeaders = new HttpHeaders();
    
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        }
    
        @RequestMapping(method = RequestMethod.PUT)
        public ResponseEntity<?> put(@RequestBody Register register) {
            HttpHeaders httpHeaders = new HttpHeaders();
    
            try {
                crudService.update(register);
            } catch (Exception e) {
                return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
            }
    
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        }
    
        @RequestMapping(method = RequestMethod.DELETE)
        public ResponseEntity<?> delete(@RequestBody Register register) {
            crudService.delete(register);
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
        }
    
    }
_Note that you will inject and use CrudService to CRUD operations._