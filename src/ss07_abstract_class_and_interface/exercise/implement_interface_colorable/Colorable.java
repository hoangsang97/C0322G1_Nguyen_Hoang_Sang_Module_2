package ss07_abstract_class_and_interface.exercise.implement_interface_colorable;

public interface Colorable {
    default String howToColor() {
        return "Color all four sides";
    }
}
