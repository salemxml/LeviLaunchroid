#!/bin/bash
set -e

echo "=== Syncing with GitHub ==="

echo "[1/3] Fetching remote changes..."
git fetch origin main

echo "[2/3] Merging remote changes..."
git merge origin/main --no-edit --allow-unrelated-histories || {
    echo "Merge conflict detected. Trying strategy..."
    git merge origin/main --no-edit --strategy-option theirs
}

echo "[3/3] Pushing to GitHub..."
GIT_TERMINAL_PROMPT=0 git push origin main

echo ""
echo "Done! All changes pushed to GitHub."
echo "Go to: https://github.com/salemxml/LeviLaunchroid/actions"
echo "Find 'Build Release APK' and click 'Run workflow'"
