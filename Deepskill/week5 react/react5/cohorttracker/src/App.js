import "./App.css";
import CohortDetails from "./Components/CohortDetails";
import CohortsData from "./Components/CohortData";

function App() {
  return (
    <div>
      <h1 style={{ textAlign: "center" }}>Cohorts Details</h1>

      {CohortsData.map((cohort) => (
        <CohortDetails
          key={cohort.id}
          name={cohort.name}
          startedOn={cohort.startedOn}
          status={cohort.status}
          coach={cohort.coach}
          trainer={cohort.trainer}
        />
      ))}
    </div>
  );
}

export default App;
