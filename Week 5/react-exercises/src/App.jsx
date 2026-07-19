import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';

import Exercise1 from './exercises/Exercise1_MyFirstReact';
import Exercise2 from './exercises/Exercise2_StudentApp';
import Exercise3 from './exercises/Exercise3_ScoreCalculatorApp';
import Exercise4 from './exercises/Exercise4_BlogApp';
import Exercise5 from './exercises/Exercise5_CohortDetails';
import Exercise6 from './exercises/Exercise6_TrainersApp';
import Exercise7 from './exercises/Exercise7_ShoppingApp';
import Exercise8 from './exercises/Exercise8_CounterApp';
import Exercise9 from './exercises/Exercise9_CricketApp';
import Exercise10 from './exercises/Exercise10_OfficeSpaceRentalApp';
import Exercise11 from './exercises/Exercise11_EventExamplesApp';
import Exercise12 from './exercises/Exercise12_TicketBookingApp';
import Exercise13 from './exercises/Exercise13_BloggerApp';
import Exercise14 from './exercises/Exercise14_ThemeApp';
import Exercise15 from './exercises/Exercise15_TicketRaisingApp';
import Exercise16 from './exercises/Exercise16_MailRegisterApp';
import Exercise17 from './exercises/Exercise17_FetchUserApp';
import Exercise18 from './exercises/Exercise18_CohortUnitTesting';
import Exercise19 from './exercises/Exercise19_GitClientTesting';

function App() {
  const exercises = [
    { path: "/ex1", component: <Exercise1 />, title: "Exercise 1: MyFirstReact" },
    { path: "/ex2", component: <Exercise2 />, title: "Exercise 2: StudentApp" },
    { path: "/ex3", component: <Exercise3 />, title: "Exercise 3: ScoreCalculatorApp" },
    { path: "/ex4", component: <Exercise4 />, title: "Exercise 4: BlogApp" },
    { path: "/ex5", component: <Exercise5 />, title: "Exercise 5: CohortDetails" },
    { path: "/ex6", component: <Exercise6 />, title: "Exercise 6: TrainersApp" },
    { path: "/ex7", component: <Exercise7 />, title: "Exercise 7: ShoppingApp" },
    { path: "/ex8", component: <Exercise8 />, title: "Exercise 8: CounterApp" },
    { path: "/ex9", component: <Exercise9 />, title: "Exercise 9: CricketApp" },
    { path: "/ex10", component: <Exercise10 />, title: "Exercise 10: OfficeSpaceRentalApp" },
    { path: "/ex11", component: <Exercise11 />, title: "Exercise 11: EventExamplesApp" },
    { path: "/ex12", component: <Exercise12 />, title: "Exercise 12: TicketBookingApp" },
    { path: "/ex13", component: <Exercise13 />, title: "Exercise 13: BloggerApp" },
    { path: "/ex14", component: <Exercise14 />, title: "Exercise 14: ThemeApp" },
    { path: "/ex15", component: <Exercise15 />, title: "Exercise 15: TicketRaisingApp" },
    { path: "/ex16", component: <Exercise16 />, title: "Exercise 16: MailRegisterApp" },
    { path: "/ex17", component: <Exercise17 />, title: "Exercise 17: FetchUserApp" },
    { path: "/ex18", component: <Exercise18 />, title: "Exercise 18: CohortUnitTesting" },
    { path: "/ex19", component: <Exercise19 />, title: "Exercise 19: GitClientTesting" },
  ];

  return (
    <Router>
      <div className="app-container">
        <nav className="sidebar">
          <h3>React Pathway</h3>
          <ul>
            <li><Link to="/">Home</Link></li>
            {exercises.map((ex, idx) => (
              <li key={idx}><Link to={ex.path}>{ex.title}</Link></li>
            ))}
          </ul>
        </nav>
        <main className="content">
          <Routes>
            <Route path="/" element={<h2>Select an exercise from the sidebar to view its implementation.</h2>} />
            {exercises.map((ex, idx) => (
              <Route key={idx} path={ex.path} element={ex.component} />
            ))}
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
