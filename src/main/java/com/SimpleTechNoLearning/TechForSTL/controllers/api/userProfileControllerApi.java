//package com.SimpleTechNoLearning.TechForSTL.controllers.api;
//
//import com.SimpleTechNoLearning.TechForSTL.data.UserRepository;
//import com.SimpleTechNoLearning.TechForSTL.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//
//
//    @CrossOrigin(origins="http://localhost.8080", maxAge = 3600)
//    @RestController
//    @RequestMapping("/user")
//    public class userProfileControllerApi {
//
//        @Autowired
//        private TaskRepository taskRepository;// injecting  CRUDRepository
//
//        @PostMapping("/add")
//        public ResponseEntity postTheTask(@RequestBody Task newTask) {
//            return new ResponseEntity<>(taskRepository.save(newTask), HttpStatus.CREATED);
//        }
//
//        @GetMapping("/alltasks")
//        public ResponseEntity getAllTasks() {
//            List<Task> tasks = (List<Task>) taskRepository.findAll();
//            return new ResponseEntity<>(tasks, HttpStatus.OK);
//
//        }
//
//
//        @GetMapping("/{id}")//ResponseEntity is class
//        public ResponseEntity getTaskById(@PathVariable Integer id) {
//
//
//            Optional<Task> optTask = taskRepository.findById(id);
//
//            if (optTask.isPresent()) {
//                return new ResponseEntity<>(optTask.get(), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(optTask.get(), HttpStatus.NOT_FOUND);
//            }
//        }
//
//        @PutMapping("/{id}")
//        public ResponseEntity updateTask(@PathVariable int id, @RequestBody Task newTask) {
//            Optional<Task> optTask = taskRepository.findById(id);
//            if (optTask.isPresent()) {
//                Task task = (Task) optTask.get();
//                newTask.setDescription(newTask.getDescription());
//                return new ResponseEntity(taskRepository.save(newTask), HttpStatus.ACCEPTED);
//            } else if (!taskRepository.existsById(id)) {
//                return new ResponseEntity(HttpStatus.NOT_FOUND);
//            } else
//                return null;
//        }
//
//
////    @DeleteMapping("/{id}")
////    public ResponseEntity deleteTheTask(@PathVariable int id) {
////        taskRepository.deleteById(id);
////        if (!taskRepository.existsById(id)) {
////            return new ResponseEntity(HttpStatus.NO_CONTENT);
////        }
////        return new ResponseEntity(HttpStatus.NOT_FOUND);
////    }
//
//
//        @DeleteMapping("/{ids}")
//        public ResponseEntity<?> deleteByIds(@PathVariable("ids") List<Integer> ids) {
//            ids.forEach(id -> {
//                if (taskRepository.existsById(id)) {
//
//                    taskRepository.deleteById(id);
//                }
//            });
//            return ResponseEntity.ok().body("Task removed");
//        }
//
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity updateTask(@PathVariable int id, @RequestBody Task newTask) {
////        Optional<Task> optTask = taskRepository.findById(id);
//////        List<Task> optTask = taskRepository.findById(id);
//////        Task theTask = taskRepository.findById(id);
////
////////        List<Task> optTask = taskRepository.findById(Id);
//////      if (optTask.isPresent()) {
//////        if (id != null) {
////
////
//////            if (!taskRepository.existsById(id)) {
//////                optTask.set(getTaskById(id));
////
//////                Object task;
////                return taskRepository.findById(id)
////                                .map(task -> {
////
////                        newTask.setDescription(newTask.getDescription());
////                })
////                return new ResponseEntity(taskRepository.save(newTask), HttpStatus.ACCEPTED);
////        }
////
////
////        return null;
////    }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity deleteTheTask(@PathVariable int id) {
////        boolean deleted = Event.deleteItem(id);
//            userRepository.deleteById(id);
//            if (!userRepository.existsById(id)) {
//                return new ResponseEntity(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
//
//}
