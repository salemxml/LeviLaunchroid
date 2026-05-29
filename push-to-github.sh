#!/bin/bash
set -e

if [ -z "$GITHUB_PAT" ]; then
    echo "ERROR: GITHUB_PAT not found in environment."
    echo "Make sure it is added in Replit Secrets tab."
    exit 1
fi

echo "=== Setting up credentials ==="
git config --global credential.helper store
echo "https://salemxml:${GITHUB_PAT}@github.com" > ~/.git-credentials
chmod 600 ~/.git-credentials

echo "=== Fetching remote changes ==="
git fetch origin main

echo "=== Merging ==="
git merge origin/main --no-edit --allow-unrelated-histories 2>/dev/null || true

echo "=== Pushing to GitHub ==="
GIT_TERMINAL_PROMPT=0 git push origin main

echo ""
echo "✓ Done! All changes pushed to GitHub."
echo "→ https://github.com/salemxml/LeviLaunchroid/actions"
