import os

base_path = r"d:\Clg\Cogni\Java FSE\Deepskilling\Solution\Week5_React\react-exercises\src\exercises"

exercises = [
    "Exercise1_MyFirstReact",
    "Exercise2_StudentApp",
    "Exercise3_ScoreCalculatorApp",
    "Exercise4_BlogApp",
    "Exercise5_CohortDetails",
    "Exercise6_TrainersApp",
    "Exercise7_ShoppingApp",
    "Exercise8_CounterApp",
    "Exercise9_CricketApp",
    "Exercise10_OfficeSpaceRentalApp",
    "Exercise11_EventExamplesApp",
    "Exercise12_TicketBookingApp",
    "Exercise13_BloggerApp",
    "Exercise14_ThemeApp",
    "Exercise15_TicketRaisingApp",
    "Exercise16_MailRegisterApp",
    "Exercise17_FetchUserApp",
    "Exercise18_CohortUnitTesting",
    "Exercise19_GitClientTesting"
]

os.makedirs(base_path, exist_ok=True)

for i, ex in enumerate(exercises, 1):
    ex_path = os.path.join(base_path, ex)
    os.makedirs(ex_path, exist_ok=True)
    
    # Create an index.jsx file for each exercise
    content = f"""import React from 'react';

export default function {ex.split('_')[1]}() {{
    return (
        <div>
            <h2>{ex.split('_')[1]}</h2>
            <p>Exercise {i} Implementation goes here.</p>
        </div>
    );
}}
"""
    with open(os.path.join(ex_path, "index.jsx"), "w") as f:
        f.write(content)

print("Scaffolding complete.")
