```bash
git:
# 
git pull = git fetch + git merge demussong
#
git push 
git push -f #强制直接覆盖仓库中的代码 
#
git branch   # 显示本地所有分支（不包括本地的远程分支）
git branch -a   # 显示本地所有分支（包括本地的远程分支）
# 
git fetch  #拉取别人的提交记录，并更新本地其他人的远程分支，但不会修改工作区代码，（如果有新的远程分支，不会自动创建本地的远程分支）
git fetch origin dev-szh:dev-szh  #拉取别人的提交记录，并更新本地其他人的远程分支，但不会修改工作区代码,（如果有新的远程分支，会自动创建本地的远程分支
#
git checkout -b dev-demussong origin/dev-demussong. # git fetch不会在本地创建新的分支，这种写法会检出并切换到新分支

# git add
git reset HEAD  #取消add,但保留工作区的修改
git reset --soft HEAD  #工作区、暂存区都没有变化
git reset --hard HEAD  #取消add,工作区的修改
# git commit
git reset --soft HEAD^  #取消commit,保留工作区和暂存区
git reset --hard HEAD^  #取消所有修改
# 添加.gitignore
添加文件

git rm -r --cached .  # 将所有文件取消纳入版本管理（.gitignore无法控制已经纳入版本管理的文件）

git add .

git commit -m 'update .gitignore'

# 从当前分支复制新分支newBranch
git checkout -b newBranch

# 将当前分支完全改为其他分支
git reset --hard origin/dos-test
```

.gitignore

```shell
# Default ignored files
/shelf/
/workspace.xml
# Editor-based HTTP Client requests
/httpRequests/
# Datasource local storage ignored files
/dataSources/
/dataSources.local.xml
logs/
target/
.idea/
.gitignore
```
