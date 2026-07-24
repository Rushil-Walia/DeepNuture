# This script implements the solutions for Week 6 Git Hands-on Labs (1 to 5).
# It automates the Git commands described in the hands-on requirements.

$ErrorActionPreference = "Stop"
$WorkingDir = ".\GitDemo"
$RemoteRepo = ".\GitRemoteRepo.git"

Write-Host "========== Exercise 1: Git Configuration & Init =========="
# Clean up if already exists
if (Test-Path $WorkingDir) { Remove-Item -Recurse -Force $WorkingDir }
if (Test-Path $RemoteRepo) { Remove-Item -Recurse -Force $RemoteRepo }

# Create remote bare repo
Write-Host "Creating remote bare repository..."
mkdir $RemoteRepo | Out-Null
Set-Location $RemoteRepo
git init --bare
Set-Location ..

# Create local repo
Write-Host "Initializing local repository in $WorkingDir..."
mkdir $WorkingDir | Out-Null
Set-Location $WorkingDir
git init
git config user.name "John Doe"
git config user.email "john.doe@example.com"
git config core.editor "notepad"

Write-Host "Adding a file to source code repository..."
"Hello World!" | Out-File "readme.txt"
git add readme.txt
git commit -m "Initial commit with readme"
Write-Host "Exercise 1 completed.`n"

Write-Host "========== Exercise 2: Git Ignore =========="
Write-Host "Creating .log files and log folder..."
mkdir "log" | Out-Null
"Log data" | Out-File "log\app.log"
"More log data" | Out-File "test.log"

Write-Host "Updating .gitignore..."
"*.log`nlog/" | Out-File ".gitignore"
git add .gitignore
git commit -m "Added .gitignore to ignore log files and folders"

Write-Host "Checking git status to verify ignore rules..."
git status
Write-Host "Exercise 2 completed.`n"

Write-Host "========== Exercise 3: Branching and Merging =========="
Write-Host "Creating new branch GitNewBranch..."
git branch GitNewBranch
git branch -a
git checkout GitNewBranch

Write-Host "Adding files to new branch..."
"Branch content" | Out-File "branch_feature.txt"
git add branch_feature.txt
git commit -m "Added feature in GitNewBranch"
git status

Write-Host "Merging GitNewBranch into master..."
git checkout master
git merge GitNewBranch -m "Merged GitNewBranch into master"
git log --oneline --graph --decorate
git branch -d GitNewBranch
Write-Host "Exercise 3 completed.`n"

Write-Host "========== Exercise 4: Merge Conflict =========="
Write-Host "Creating branch GitWork..."
git checkout -b GitWork
"<hello>Branch content</hello>" | Out-File "hello.xml"
git add hello.xml
git commit -m "Added hello.xml in GitWork"

Write-Host "Switching to master and creating conflict..."
git checkout master
"<hello>Master content</hello>" | Out-File "hello.xml"
git add hello.xml
git commit -m "Added hello.xml in master"

Write-Host "Merging GitWork to master (Expecting Conflict)..."
git merge GitWork 2>$null; if (!$?) { Write-Host "Merge conflict occurred as expected." }

Write-Host "Resolving conflict..."
"<hello>Resolved content</hello>" | Out-File "hello.xml"
git add hello.xml
git commit -m "Resolved merge conflict between master and GitWork"
git log --oneline --graph --decorate --all
git branch -d GitWork
Write-Host "Exercise 4 completed.`n"

Write-Host "========== Exercise 5: Clean up and Push =========="
Write-Host "Adding remote repository and pushing..."
git remote add origin "..\$RemoteRepo"
git pull origin master 2>$null; if (!$?) { Write-Host "Nothing to pull from fresh remote." }
git push -u origin master
Write-Host "Checking remote branches..."
git branch -r
Write-Host "Exercise 5 completed.`n"

Write-Host "All Git hands-on exercises successfully automated!"
Set-Location ..
