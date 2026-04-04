package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        solve(model.getHeight(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //
    private void solve(int n, int source, int destination, int auxiliary)
    {
        if (n == 0) return;
        solve(n - 1, source, auxiliary, destination);
        model.move(source, destination);
        solve(n - 1, auxiliary, destination, source);
    }

}