public class Student {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String toFileString() {
            return id + "," + name + "," + age;
        }

        public static Student fromFileString(String line) {
            String[] parts = line.split(",");
            return new Student(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2])
            );
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age;
        }
    }

